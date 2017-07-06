package br.com.solimar.desafiomobfiq.fragments;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import br.com.solimar.desafiomobfiq.ListCategoryActivity;
import br.com.solimar.desafiomobfiq.R;
import br.com.solimar.desafiomobfiq.adapters.ProductListAdapter;
import br.com.solimar.desafiomobfiq.connections.RetrofitConnection;
import br.com.solimar.desafiomobfiq.models.ResultadoJsonProducts;
import br.com.solimar.desafiomobfiq.services.MobfiqService;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by Solimar on 04/07/2017.
 */

public class ListProductFragment extends Fragment {

    @BindView(R.id.lvProducts)
    RecyclerView recyclerView;
    @BindView(R.id.progressList)
    ProgressBar progressBar;
    private LinearLayoutManager manager;
    ProductListAdapter adapterProduct;
    MobfiqService mobService;
    String search;
    Integer offSet;
    Boolean resetAdapter;
    private boolean loading = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        ButterKnife.bind(this, view);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        manager = new GridLayoutManager(getActivity(), 2);
        manager.setOrientation(StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        initListeners();
        progressBar.getIndeterminateDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
        if (savedInstanceState != null) {
            if (adapterProduct != null) {
                recyclerView.setAdapter(adapterProduct);
                adapterProduct.notifyDataSetChanged();
            } else {
                initRecycler();
            }
        } else {
            initRecycler();
        }
        return view;
    }

    private void initRecycler() {
        search = "";
        offSet = 0;
        resetAdapter = true;
        getProducts();
    }

    private void initListeners() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int visibleItemCount = manager.getChildCount();
                int totalItemCount = manager.getItemCount();
                int pastVisibleItems = manager.findFirstVisibleItemPosition();
                if (loading) {
                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        loading = false;
                        resetAdapter = false;
                        offSet += 10;
                        getProducts();
                    }
                }
            }
        });
    }

    private void getProducts() {
        progressBar.setVisibility(View.VISIBLE);
        mobService = RetrofitConnection.createRetrofitService(MobfiqService.class);
        mobService.search(search, offSet, getResources().getInteger(R.integer.listsize))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Response response) {
                        ResultadoJsonProducts resultadoJsonProducts = (ResultadoJsonProducts) response.body();
                        if (resultadoJsonProducts.getProducts() != null && !resultadoJsonProducts.getProducts().isEmpty()) {
                            if (adapterProduct == null || resetAdapter) {
                                adapterProduct = new ProductListAdapter(resultadoJsonProducts.getProducts(), getActivity());
                                recyclerView.setAdapter(adapterProduct);
                            } else {
                                adapterProduct.add(resultadoJsonProducts.getProducts());
                                manager.scrollToPosition(manager.findLastVisibleItemPosition() + 1);
                            }
                            adapterProduct.notifyDataSetChanged();
                        } else if(offSet == 0){
                            Toast.makeText(getActivity(),getString(R.string.sem_produtos),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (offSet != 0) {
                            offSet -= 10;
                        }
                        loading = true;
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onComplete() {
                        progressBar.setVisibility(View.GONE);
                        loading = true;
                    }
                });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(getActivity().SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        addTextListener(searchView);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void addTextListener(final SearchView searchView) {
        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search = query;
                offSet = 0;
                resetAdapter = true;
                getProducts();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        };
        searchView.setOnQueryTextListener(queryTextListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.category) {
            startActivity(new Intent(getActivity(), ListCategoryActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

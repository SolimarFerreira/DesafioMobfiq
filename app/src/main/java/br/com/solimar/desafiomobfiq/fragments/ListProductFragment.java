package br.com.solimar.desafiomobfiq.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import br.com.solimar.desafiomobfiq.R;
import br.com.solimar.desafiomobfiq.adapters.ProductListAdapter;
import br.com.solimar.desafiomobfiq.connections.RetrofitConnection;
import br.com.solimar.desafiomobfiq.models.ResultadoJson;
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

public class ListProductFragment extends Fragment{

    @BindView(R.id.lvProducts)
    RecyclerView recyclerView;
    @BindView(R.id.progressList)
    ProgressBar progressBar;
    private LinearLayoutManager manager;
    ProductListAdapter adapterProduct;
    MobfiqService mobService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        ButterKnife.bind(this, view);
        setRetainInstance(true);
        manager = new GridLayoutManager(getActivity(), 2);
        manager.setOrientation(StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        if(savedInstanceState !=null){
            if(adapterProduct!=null){
                recyclerView.setAdapter(adapterProduct);
                adapterProduct.notifyDataSetChanged();
            }
        }else{
            getProducts();
        }
        return view;
    }

    private void getProducts() {

        mobService = RetrofitConnection.createRetrofitService(MobfiqService.class);
        mobService.search("",0,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Response response) {
                        ResultadoJson resultadoJson = (ResultadoJson) response.body();
                        adapterProduct = new ProductListAdapter(resultadoJson.getProducts());
                        recyclerView.setAdapter(adapterProduct);
                        adapterProduct.notifyDataSetChanged();
                        Log.i("ern fn", response.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("ern fn", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

package br.com.solimar.desafiomobfiq.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.solimar.desafiomobfiq.R;
import br.com.solimar.desafiomobfiq.connections.RetrofitConnection;
import br.com.solimar.desafiomobfiq.models.Category;
import br.com.solimar.desafiomobfiq.models.ResultadoJsonCategory;
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
 * Created by Solimar on 06/07/2017.
 */

public class ListCategoryFragment extends Fragment{

    @BindView(R.id.lvCategory)
    ListView listView;
    @BindView(R.id.progressList)
    ProgressBar progressBar;
    private LinearLayoutManager manager;
    MobfiqService mobService;
    ArrayAdapter<Category> adapterCategory;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        ButterKnife.bind(this, view);
        setRetainInstance(true);

        if(savedInstanceState !=null){
            if(adapterCategory!=null){
                listView.setAdapter(adapterCategory);
                adapterCategory.notifyDataSetChanged();
            }
        }else{
            getCategories();
        }
        return view;
    }

    private void getCategories() {

        mobService = RetrofitConnection.createRetrofitService(MobfiqService.class);
        mobService.listCategorias()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull Response response) {
                        ResultadoJsonCategory resultadoJson = (ResultadoJsonCategory) response.body();
                        adapterCategory = new ArrayAdapter<Category>(getActivity(),android.R.layout.simple_list_item_1, resultadoJson.getCategories());
                        listView.setAdapter(adapterCategory);
                        adapterCategory.notifyDataSetChanged();
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

package br.com.solimar.desafiomobfiq.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import br.com.solimar.desafiomobfiq.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Solimar on 04/07/2017.
 */

public class ListProductFragment extends Fragment{

    @BindView(R.id.lvProducts)
    RecyclerView recyclerView;
    @BindView(R.id.progressList)
    ProgressBar progressBar;
    private LinearLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        ButterKnife.bind(this, view);
        setRetainInstance(true);
        manager = new GridLayoutManager(getActivity(), 1);
        manager.setOrientation(StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        if(savedInstanceState !=null){

        }else{

        }
        return view;
    }
}

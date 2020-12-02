package com.example.inventory.iu.dependency;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.inventory.R;


public class ListDependencyFragment extends Fragment implements ListDependencyContract.View{

    private LinearLayout llLoading;
    private LinearLayout llNoData;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_dependency, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        llLoading = view.findViewById(R.id.llLoading);
        llNoData = view.findViewById(R.id.llNoData);
    }

    /**
     * Metodo que muestra el linearLayout que contiene el porgressbar
     */
    @Override
    public void showProgress() {
        llLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        llLoading.setVisibility(View.GONE);

    }

    @Override
    public void setNoData() {
        llNoData.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccess() {
        //1. Si esta visible NoData se cambia visibilidad a GONE
        //2. Se carga los datos en el Recycler
    }
}
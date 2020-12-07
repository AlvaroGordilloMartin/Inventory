package com.example.inventory.iu.dependency;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;

import com.example.inventory.R;
import com.example.inventory.data.model.Dependency;
import com.example.inventory.data.repository.DependencyRepository;
import com.example.inventory.iu.adapter.DependencyAdapter;

import java.util.List;


public class ListDependencyFragment extends Fragment implements ListDependencyContract.View{

    private LinearLayout llLoading;
    private LinearLayout llNoData;
    private RecyclerView rvDependency;
    private DependencyAdapter adapter;
    private  ListDependencyPresenter presenter;
    private DependencyRepository repository = new DependencyRepository();

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
        rvDependency = view.findViewById(R.id.rvDepedency);

        //1. Crear el Adapter
        adapter = new DependencyAdapter(repository.getList());

        //2. Hay que crear el diseño del RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);

        //3. Se asigna el diseño al RecyclerView
        rvDependency.setLayoutManager(layoutManager);

        //4. Vincular la vista al modelo
        rvDependency.setAdapter(adapter);

        presenter = new ListDependencyPresenter(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.load();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
    public void onSuccess(List<Dependency> list) {

        //1. Si esta visible NoData se cambia visibilidad a GONE
        if(llNoData.getVisibility() == View.VISIBLE)
            llNoData.setVisibility(View.GONE);

        //2. Se carga los datos en el Recycler
        adapter.update(list);
    }
}
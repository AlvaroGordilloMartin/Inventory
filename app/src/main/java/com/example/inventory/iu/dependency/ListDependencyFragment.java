package com.example.inventory.iu.dependency;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventory.R;
import com.example.inventory.data.model.Dependency;
import com.example.inventory.data.repository.DependencyRepository;
import com.example.inventory.iu.adapter.DependencyAdapter;
import com.example.inventory.iu.addedit.AddEditListDependencyFragment;
import com.example.inventory.iu.base.BaseDialogFragment;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListDependencyFragment extends Fragment implements ListDependencyContract.View, DependencyAdapter.OnLongClickListener,BaseDialogFragment.OnPositiveClickListener {

    private LinearLayout llLoading;
    private LinearLayout llNoData;
    private RecyclerView rvDependency;
    private DependencyAdapter adapter;
    private ListDependencyPresenter presenter;
    private DependencyAdapter.OnItemClickListener listener;
    private DependencyAdapter.OnLongClickListener longClickListener;

    //Lista Dependency
    private DependencyRepository repository = new DependencyRepository();
    private List<Dependency> list = repository.getList();

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
        setHasOptionsMenu(true);

        llNoData.setVisibility(View.GONE);
        if (list.size() == 0)
            llNoData.setVisibility(View.VISIBLE);

        //OnClick que se encarga del cuando se pulsa un objeto del reciclerView mostrar su informacion
        listener = new DependencyAdapter.OnItemClickListener() {
            @Override
            public void onClick(final View view) {
/*
                llLoading.setVisibility(View.VISIBLE);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Dependency dependency = new Dependency(list.get(rvDependency.getChildAdapterPosition(view)).getName(),
                                list.get(rvDependency.getChildAdapterPosition(view)).getShortname(),
                                list.get(rvDependency.getChildAdapterPosition(view)).getDesciption(),
                                "");

                        Bundle bundle = new Bundle();
                        bundle.putSerializable(Dependency.TAG,dependency);
                        bundle.putInt("id", rvDependency.getChildAdapterPosition(view));


                        MandarDatos(bundle);

                    }
                }, 1000);

*/

                Toast.makeText(getContext(),"Nombre: "+list.get(rvDependency.getChildAdapterPosition(view)).getName(),Toast.LENGTH_SHORT).show();
            }
        };







        //1. Crear el Adapter
        adapter = new DependencyAdapter(list, listener,longClickListener);



        //2. Hay que crear el diseño del RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        //3. Se asigna el diseño al RecyclerView
        rvDependency.setLayoutManager(layoutManager);

        //4. Vincular la vista al modelo
        rvDependency.setAdapter(adapter);

        presenter = new ListDependencyPresenter(this);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
           case R.id.action_sort:
                Toast.makeText(getContext(),"Ordenando por Nombre",Toast.LENGTH_SHORT).show();
                sortList();
                break;
       }
        return true;
    }

    public void sortList(){
        Collections.sort(list, new Comparator<Dependency>() {
            @Override
            public int compare(Dependency o1, Dependency o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        adapter.notifyDataSetChanged();
    }

    public void MandarDatos(Bundle bundle){
        NavHostFragment.findNavController(this).navigate(R.id.action_listDependencyFragment_to_addEditListDependencyFragment,bundle);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.load();
        if(getArguments()!=null) {
            if (getArguments().getBoolean(BaseDialogFragment.CONFIRM_DELETE))
                onPositiveClick();
        }
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
        if (llNoData.getVisibility() == View.VISIBLE)
            llNoData.setVisibility(View.GONE);

        //2. Se carga los datos en el Recycler
        adapter.update(list);
    }


    @Override
    public void Delete(Dependency dependency) {
        Bundle bundle = new Bundle();
        bundle.putString(BaseDialogFragment.TITLE,getString(R.string.title_delete_dependency));
        bundle.putString(BaseDialogFragment.MESSAGE,String.format(getString(R.string.message_delete_dependency),dependency.getShortname()));
        NavHostFragment.findNavController(ListDependencyFragment.this).navigate(R.id.action_listDependencyFragment_to_baseDialogFragment,bundle);
    }


    /**
     * Este metodo se ejecuta cuando el usuario pulsa el boton aceptar
     * en el cuadro de dialogo que pide confirmacion
     */
    @Override
    public void onPositiveClick() {

    }
}
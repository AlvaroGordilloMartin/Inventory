package com.example.inventory.iu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.inventory.R;
import com.example.inventory.iu.dependency.ListDependencyFragment;


public class DashBoardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashBoardFragment() {
        // Required empty public constructor
    }


    public static DashBoardFragment newInstance(String param1, String param2) {
        DashBoardFragment fragment = new DashBoardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);

        Button btDependencias = view.findViewById(R.id.btDependencias);
        Button btSettings = view.findViewById(R.id.btConfiguracion);

        btDependencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirDependencyList();
            }
        });
        btSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirConfiguracion();
            }
        });

        return view;
    }

    public  void AbrirDependencyList(){
        NavHostFragment.findNavController(this).navigate(R.id.action_dashBoardFragment_to_listDependencyFragment,null);
    }

    public void AbrirConfiguracion(){
        NavHostFragment.findNavController(this).navigate(R.id.action_dashBoardFragment_to_settingsFragment,null);
    }


}
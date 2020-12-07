package com.example.inventory.iu.addedit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inventory.R;
import com.example.inventory.iu.adapter.DependencyAdapter;
import com.github.ivbaranov.mli.MaterialLetterIcon;


public class AddEditListDependencyFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView txtName;
    TextView txtShortName;
    TextView txtDescription;

    public AddEditListDependencyFragment() {
        // Required empty public constructor
    }

    public static AddEditListDependencyFragment newInstance(String param1, String param2) {
        AddEditListDependencyFragment fragment = new AddEditListDependencyFragment();
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
        return inflater.inflate(R.layout.fragment_add_edit_list_dependency, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtName = view.findViewById(R.id.txtName);
        txtShortName = view.findViewById(R.id.txtShortName);
        txtDescription = view.findViewById(R.id.txtDescription);

        Bundle bundle = getArguments();

        txtName.setText(bundle.getString("Name"));
        txtShortName.setText(bundle.getString("ShortName"));
        txtDescription.setText(bundle.getString("Description"));
    }




}
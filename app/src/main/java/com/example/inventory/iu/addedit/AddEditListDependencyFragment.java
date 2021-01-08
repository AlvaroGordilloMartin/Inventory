package com.example.inventory.iu.addedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.inventory.R;
import com.example.inventory.data.model.Dependency;
import com.example.inventory.data.repository.DependencyRepository;


public class AddEditListDependencyFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    int id;

    EditText edtName;
    EditText edtShortName;
    EditText edtDescription;

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
        edtName = view.findViewById(R.id.edtName);
        edtShortName = view.findViewById(R.id.edtShortName);
        edtDescription = view.findViewById(R.id.edtDescription);

        Bundle bundle = getArguments();

        id = bundle.getInt("id");

        Dependency dependency = (Dependency) bundle.getSerializable(Dependency.TAG);

        edtName.setText(dependency.getName());
        edtShortName.setText(dependency.getShortname());
        edtDescription.setText(dependency.getDesciption());

        Button btCambios = view.findViewById(R.id.btCambios);

        btCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dependency dependency = new Dependency(edtName.getText().toString(),edtShortName.getText().toString(),edtDescription.getText().toString(),"");
                DependencyRepository.getInstance().editar(dependency,id);
                NavHostFragment.findNavController(AddEditListDependencyFragment.this).navigate(R.id.action_addEditListDependencyFragment_to_listDependencyFragment);
            }
        });



    }




}
package com.example.inventory.iu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.inventory.R;
import com.example.inventory.data.repository.DependencyRepository;
import com.example.inventory.iu.dependency.ListDependencyFragment;

import java.util.Collections;

public class InventoryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListDependencyFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
//        toolbar = findViewById(R.id.toolbar);
//        //Activity muestre la barra Toolbar se tiene que incluir esta llamada al metodo
//        setSupportActionBar(toolbar);
        

    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_inventory, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_sort:
//                Toast.makeText(fragment.getContext(),"OLE",Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return true;
//    }
}
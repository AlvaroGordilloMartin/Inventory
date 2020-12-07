package com.example.inventory.iu.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventory.R;
import com.example.inventory.data.model.Dependency;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.List;
import java.util.logging.Logger;

public class DependencyAdapter extends RecyclerView.Adapter<DependencyAdapter.ViewHolder> {

    private List<Dependency> list;
    private  OnItemClickListener listener;

    public interface OnItemClickListener extends View.OnClickListener{
        void onClick(View view);

    }

    public DependencyAdapter(List<Dependency> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dependency,parent,false);
        view.setOnClickListener(listener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iconLetter.setLetter(list.get(position).getShortname());
        holder.tvShortName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    /**
     * Metodo que actualiza los datos del RecyclerView y se debe llamar al metodo para que la vista se anule y se vuela a dibujar
     */
    public void update(List<Dependency> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }



    public class ViewHolder extends  RecyclerView.ViewHolder{

        MaterialLetterIcon iconLetter;
        TextView tvShortName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconLetter=itemView.findViewById(R.id.iconLetter);
            tvShortName=itemView.findViewById(R.id.tvShortName);
        }
    }
}

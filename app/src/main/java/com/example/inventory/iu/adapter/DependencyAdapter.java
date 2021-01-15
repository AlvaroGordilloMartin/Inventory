package com.example.inventory.iu.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventory.R;
import com.example.inventory.data.model.Dependency;
import com.example.inventory.iu.addedit.AddEditListDependencyFragment;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.List;

public class DependencyAdapter extends RecyclerView.Adapter<DependencyAdapter.ViewHolder> {

    private List<Dependency> list;
    private OnItemClickListener listener;
    private OnLongClickListener longListener;


    public interface OnItemClickListener extends View.OnClickListener {
        void onClick(View view);

    }

    public  interface OnLongClickListener{
        void Delete(Dependency dependency);
    }

    public DependencyAdapter(List<Dependency> list, OnItemClickListener listener, OnLongClickListener longListener) {
        this.list = list;
        this.listener = listener;
        this.longListener=longListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dependency, parent, false);
        view.setOnClickListener(listener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.iconLetter.setLetter(list.get(position).getShortname());
        holder.tvShortName.setText(list.get(position).getName());
        holder.bind(list.get(position),longListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    /**
     * Metodo que actualiza los datos del RecyclerView y se debe llamar al metodo para que la vista se anule y se vuela a dibujar
     */
    public void update(List<Dependency> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        MaterialLetterIcon iconLetter;
        TextView tvShortName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconLetter = itemView.findViewById(R.id.iconLetter);
            tvShortName = itemView.findViewById(R.id.tvShortName);
        }

        public  void bind(final Dependency item, final OnLongClickListener listener){
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.Delete(item);
                    return true;
                }
            });
        }


    }


}

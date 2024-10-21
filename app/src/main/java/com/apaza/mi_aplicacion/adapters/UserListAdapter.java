package com.apaza.mi_aplicacion.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apaza.mi_aplicacion.R;
import com.apaza.mi_aplicacion.entidades.EUser;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListHolder> {
    List<EUser> items;

    public UserListAdapter(List<EUser> items) {
        this.items = items;
    }

    @Override
    public UserListHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view
                        , parent, false);
        return new UserListHolder(view);
    }

    @Override
    public void onBindViewHolder(UserListHolder holder, int position) {
        EUser data = items.get(position);
        holder.mostrar(data);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
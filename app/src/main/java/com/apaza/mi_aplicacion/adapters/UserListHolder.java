package com.apaza.mi_aplicacion.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.apaza.mi_aplicacion.R;
import com.apaza.mi_aplicacion.entidades.EUser;

public class UserListHolder extends RecyclerView.ViewHolder {
    TextView tv_nombre,tv_user;
    ImageView btn_editar,btn_eliminar;
    public UserListHolder( View view) {
        super(view);
        tv_nombre=view.findViewById(R.id.tv_rvi_nombres);
        tv_user=view.findViewById(R.id.tv_rvi_user);
        btn_editar=view.findViewById(R.id.btn_rviu_editar);
        btn_eliminar=view.findViewById(R.id.btn_rviu_eliminar);
    }
    public void mostrar(EUser data){
        tv_user.setText(data.getUsuario());
        tv_nombre.setText(data.getNombre()+" "+data.getApellido());
        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editar(data);
            }
        });
        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar(data);
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verdetalle(data);
            }
        });
    }
    private void verdetalle(EUser data) {
        showMessage("Enviando mensaje desde el item con apelldios: "+data.getApellido());
    }
    private void eliminar(EUser data) {
        showMessage("enviado desde elimianr con nombre: "+data.getNombre());
    }
    private void editar(EUser data) {
        showMessage("enviando mensaje desde editar con: "+data.getNombre());
    }
    private void showMessage(String message){

        Toast.makeText(itemView.getContext(),message,Toast.LENGTH_SHORT).show();
    }
}
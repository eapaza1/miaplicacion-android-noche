package com.apaza.mi_aplicacion.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apaza.mi_aplicacion.R;
import com.apaza.mi_aplicacion.entidades.EUser;

public class UserListHolder extends RecyclerView.ViewHolder {

    private TextView tv_nombres,tv_usuario;
    private ImageView btn_editar,btn_eliminar;

    public UserListHolder(View view) {
        super(view);
        tv_nombres= view.findViewById(R.id.tv_rvi_nombres);
        tv_usuario= view.findViewById(R.id.tv_rvi_user);

        btn_editar=view.findViewById(R.id.btn_rviu_editar);
        btn_eliminar=view.findViewById(R.id.btn_rviu_eliminar);

        //evetnos de botones
        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editar();
            }
        });

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar();
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verPerfil();
            }
        });
    }

    private void verPerfil() {
        Toast.makeText(itemView.getContext(),"presionaste el elemento",Toast.LENGTH_LONG).show();

    }

    private void editar() {
        Toast.makeText(itemView.getContext(),"presionaste boton editar",Toast.LENGTH_LONG).show();
    }

    private void eliminar(){

        Toast.makeText(itemView.getContext(),"presionaste boton eliminar",Toast.LENGTH_LONG).show();
    }

    public void  mostar(EUser data){
        tv_nombres.setText(data.getNombre()+" "+data.getApellido());
        tv_usuario.setText(data.getUsuario());
    }


}

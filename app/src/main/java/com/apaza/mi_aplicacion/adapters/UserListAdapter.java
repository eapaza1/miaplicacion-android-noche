package com.apaza.mi_aplicacion.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apaza.mi_aplicacion.AddUserActivity;
import com.apaza.mi_aplicacion.R;
import com.apaza.mi_aplicacion.entidades.EUser;
import com.apaza.mi_aplicacion.modelo.UserModelo;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListHolder> {

    private List<EUser> items;
    private Context context;

    public UserListAdapter(List<EUser> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    public UserListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);

        return new UserListHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListHolder holder, int position) {
        EUser data = items.get(position);

        holder.mostar(data, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void eliminarUser(EUser data, int position) {
        UserModelo modelo = new UserModelo(context);

        //resultado de eliminar en base de datos
        int res=modelo.Delete(data.getId());
        //valido el resultado
        if (res>0){
            items.remove(position);
            notifyItemRemoved(position);
        }
    }

    //clase holder
    public class UserListHolder extends RecyclerView.ViewHolder {

        private int indice;
        private EUser usuario;
        private TextView tv_nombres, tv_usuario;
        private ImageView btn_editar, btn_eliminar;

        public UserListHolder(View view) {
            super(view);
            tv_nombres = view.findViewById(R.id.tv_rvi_nombres);
            tv_usuario = view.findViewById(R.id.tv_rvi_user);

            btn_editar = view.findViewById(R.id.btn_rviu_editar);
            btn_eliminar = view.findViewById(R.id.btn_rviu_eliminar);

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
            Toast.makeText(itemView.getContext(), "presionaste el elemento", Toast.LENGTH_LONG).show();

        }

        private void editar() {
            Intent intent = new Intent(itemView.getContext(), AddUserActivity.class);
            intent.putExtra("userEdit", usuario);
            itemView.getContext().startActivity(intent);
            Toast.makeText(itemView.getContext(), "presionaste boton editar", Toast.LENGTH_LONG).show();
        }

        private void eliminar() {

            AlertDialog.Builder alerta = new AlertDialog.Builder(itemView.getContext());

            alerta.setTitle("ALERTA");
            alerta.setMessage("¿Estas seguro de eliminar el usuario: " + usuario.getNombre() + " ?");
            alerta.setPositiveButton("Eliminar", (dialog, i) -> {
                eliminarUser(usuario,indice);
            });
            alerta.setNegativeButton("Cancelar", (dialog, i) -> {
                dialog.dismiss();
            });

            alerta.create();
            alerta.show();
        }

        public void mostar(EUser data, int indice) {
            this.indice = indice;
            usuario = data;
            tv_nombres.setText(data.getNombre() + " " + data.getApellido());
            tv_usuario.setText(data.getUsuario());
        }


    }
}

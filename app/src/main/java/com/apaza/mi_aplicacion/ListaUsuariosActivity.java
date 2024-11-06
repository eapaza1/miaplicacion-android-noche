package com.apaza.mi_aplicacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apaza.mi_aplicacion.adapters.UserListAdapter;
import com.apaza.mi_aplicacion.entidades.EUser;
import com.apaza.mi_aplicacion.modelo.UserModelo;

import java.util.List;

public class ListaUsuariosActivity extends AppCompatActivity {

    Button btn_add;
    RecyclerView rv_users;

    private List<EUser> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_usuarios);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_add=findViewById(R.id.btn_lu_add);
        rv_users=findViewById(R.id.rv_lista_usuarios);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaUsuariosActivity.this,AddUserActivity.class);
                startActivity(intent);
            }
        });

        initData();


    }

    private void initData() {
        UserModelo model= new UserModelo(this);
         lista=model.ReadAll();
        rv_users.setLayoutManager(new LinearLayoutManager(this));
        UserListAdapter adapter=new UserListAdapter(lista,this);
        rv_users.setAdapter(adapter);

    }

    




}
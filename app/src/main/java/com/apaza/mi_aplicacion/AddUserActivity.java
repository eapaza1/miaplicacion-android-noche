package com.apaza.mi_aplicacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.apaza.mi_aplicacion.entidades.EUser;
import com.apaza.mi_aplicacion.modelo.UserModelo;

public class AddUserActivity extends AppCompatActivity {

    EditText txt_nombre, txt_apellido, txt_dni, txt_telefono, txt_email, txt_direccion, txt_usuario, txt_password;
    Button btn_registrar, btn_cancelar, btn_actualizar;

    EUser usuarioEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt_nombre = findViewById(R.id.txt_au_nombre);
        txt_apellido = findViewById(R.id.txt_au_apellido);
        txt_dni = findViewById(R.id.txt_au_dni);
        txt_telefono = findViewById(R.id.txt_au_telefono);
        txt_email = findViewById(R.id.txt_au_email);
        txt_direccion = findViewById(R.id.txt_au_direccion);
        txt_usuario = findViewById(R.id.txt_au_usuario);
        txt_password = findViewById(R.id.txt_au_password);

        btn_cancelar = findViewById(R.id.btn_au_cancelar);
        btn_registrar = findViewById(R.id.btn_au_agregar);
        btn_actualizar = findViewById(R.id.btn_au_actualizar);

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToList();
            }
        });

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
            }
        });

        btn_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Actualizar();
            }
        });


        //recibir informacion del intent
        Intent intent = getIntent();
        EUser usuario = (EUser) intent.getSerializableExtra("userEdit");
        if (usuario != null) {
            mostrarUsuario(usuario);
            btn_registrar.setVisibility(View.INVISIBLE);
            btn_registrar.setEnabled(false);
        }else {
            btn_actualizar.setVisibility(View.INVISIBLE);
            btn_actualizar.setEnabled(false);
        }
        //fin de recibir informacion


    }

    private void Actualizar() {
        EUser usuario = new EUser();
        usuario.setNombre(txt_nombre.getText().toString());
        usuario.setApellido(txt_apellido.getText().toString());
        usuario.setDni(txt_dni.getText().toString());
        usuario.setTelefono(txt_telefono.getText().toString());
        usuario.setDireccion(txt_direccion.getText().toString());
        usuario.setEmail(txt_email.getText().toString());
        usuario.setUsuario(txt_usuario.getText().toString());
        usuario.setPassword(txt_password.getText().toString());

        //agregamos el id seleccionado
        usuario.setId(usuarioEditar.getId());

        UserModelo modelo = new UserModelo(this);

        if (modelo.Update(usuario) > 0) {
            Toast.makeText(this, "Acutalizado Correctamente", Toast.LENGTH_SHORT).show();
            returnToList();
        } else {
            Toast.makeText(this, "Error en actualizar", Toast.LENGTH_SHORT).show();
        }

    }

    private void mostrarUsuario(EUser usuario) {
        txt_nombre.setText(usuario.getNombre());
        txt_apellido.setText(usuario.getApellido());
        txt_dni.setText(usuario.getDni());
        txt_telefono.setText(usuario.getTelefono());
        txt_direccion.setText(usuario.getDireccion());
        txt_usuario.setText(usuario.getUsuario());
        txt_password.setText(usuario.getPassword());
        txt_email.setText(usuario.getEmail());

        usuarioEditar=usuario;

    }

    private void registrar() {
        EUser usuario = new EUser();
        usuario.setNombre(txt_nombre.getText().toString());
        usuario.setApellido(txt_apellido.getText().toString());
        usuario.setDni(txt_dni.getText().toString());
        usuario.setTelefono(txt_telefono.getText().toString());
        usuario.setDireccion(txt_direccion.getText().toString());
        usuario.setEmail(txt_email.getText().toString());
        usuario.setUsuario(txt_usuario.getText().toString());
        usuario.setPassword(txt_password.getText().toString());

        UserModelo modelo = new UserModelo(this);

        if (modelo.Create(usuario) > 0) {
            Toast.makeText(this, "Insertado Correctamente", Toast.LENGTH_SHORT).show();
            returnToList();
        } else {
            Toast.makeText(this, "no insertado", Toast.LENGTH_SHORT).show();
        }
    }

    private void returnToList() {
        Intent intent = new Intent(this, ListaUsuariosActivity.class);
        startActivity(intent);
        finish();
    }


}
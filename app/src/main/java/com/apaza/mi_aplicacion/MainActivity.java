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

public class MainActivity extends AppCompatActivity {

    EditText txt_usuario,txt_password;
    Button btn_ingresar,btn_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //enlazar varibles con id-vista
        txt_usuario=findViewById(R.id.txtUsuario);
        txt_password=findViewById(R.id.txtPassword);
        btn_ingresar=findViewById(R.id.btnIngresar);
        btn_salir=findViewById(R.id.btnSalir);

        //click del boton ingresar
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ingresar();
            }
        });

        //click del boton salir
        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inent= new Intent(Intent.ACTION_MAIN);
                inent.addCategory(Intent.CATEGORY_HOME);
                inent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(inent);
            }
        });

    }

    private void Ingresar() {

        String usuario,password;

        usuario=txt_usuario.getText().toString();
        password=txt_password.getText().toString();

        if (!usuario.equals("admin")){
            Toast.makeText(this,"Usuario Incorrecto",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!password.equals("admin1234")){
            Toast.makeText(this,"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this,"Bienvenido al sistema",Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this, Inicio.class);
        startActivity(intent);


    }


}
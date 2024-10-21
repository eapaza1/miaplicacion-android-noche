package com.apaza.mi_aplicacion.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.apaza.mi_aplicacion.entidades.EUser;

import java.util.ArrayList;
import java.util.List;

public class UserModelo {
    private static String TABLE="users";
    private Conexion conexion;

    public UserModelo(Context contexto) {
        conexion=new Conexion(contexto);
    }

    public long Create(EUser data){
        SQLiteDatabase db=conexion.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put("nombre",data.getNombre());
        valores.put("apellido",data.getApellido());
        valores.put("dni", data.getDni());
        valores.put("telefono", data.getTelefono());
        valores.put("email", data.getEmail());
        valores.put("direccion", data.getDireccion());
        valores.put("usuario", data.getUsuario());
        valores.put("password", data.getPassword());
       long res= db.insert(TABLE,null,valores);
       db.close();
       return res;
    }

    public List<EUser> ReadAll(){
        List<EUser> lista=new ArrayList<>();

        SQLiteDatabase db=conexion.getReadableDatabase();
        String sql="SELECT * FROM "+TABLE;
        Cursor cursor=db.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                EUser user=new EUser();

                user.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                user.setNombre(cursor.getString(cursor.getColumnIndexOrThrow("nombre")));
                user.setApellido(cursor.getString(cursor.getColumnIndexOrThrow("apellido")));
                user.setDni(cursor.getString(cursor.getColumnIndexOrThrow("dni")));
                user.setTelefono(cursor.getString(cursor.getColumnIndexOrThrow("telefono")));
                user.setDireccion(cursor.getString(cursor.getColumnIndexOrThrow("direccion")));
                user.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
                user.setUsuario(cursor.getString(cursor.getColumnIndexOrThrow("usuario")));
                user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow("password")));

                lista.add( user);



            }while (cursor.moveToNext());
        }

        return lista;
    }
}

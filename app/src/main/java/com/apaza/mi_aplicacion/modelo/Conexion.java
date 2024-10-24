package com.apaza.mi_aplicacion.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Conexion extends SQLiteOpenHelper {

    private static String DB_NAME="database.db";
    private static int DB_VERSION=1;

    public Conexion(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
            String tabla_usuario="CREATE TABLE IF NOT EXISTS users(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre TEXT," +
                    "apellido TEXT," +
                    "dni TEXT," +
                    "telefono TEXT," +
                    "email TEXT," +
                    "direccion TEXT," +
                    "usuario TEXT," +
                    "password TEXT" +
                    ");";
            db.execSQL(tabla_usuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql="DROP TABLE IF EXISTS users";
        sqLiteDatabase.execSQL(sql);

        onCreate(sqLiteDatabase);

    }
}

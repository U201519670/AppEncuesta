package com.example.myproject1.db

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import com.example.myproject1.db.Helper
import android.database.sqlite.SQLiteDatabase

open class Helper(context: Context?) :
    SQLiteOpenHelper(context, BASE_NOMBRE, null, BASE_VERSION) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(
            " CREATE TABLE " + TABLE_LOCALES + "(" +
                    "id INTEGER PRIMARY KEY NOT NULL," +
                    "nombre TEXT NOT NULL)"
        )
        sqLiteDatabase.execSQL(
            "INSERT INTO " + TABLE_LOCALES + "(id, nombre) VALUES" +
                    "(1, 'MIRAFLORES'), " +
                    "(2, 'LA MOLINA')," +
                    "(3, 'SURCO')"
        )
        sqLiteDatabase.execSQL(
            " CREATE TABLE " + TABLE_SERVICIOS + "(" +
                    "id INTEGER PRIMARY KEY NOT NULL," +
                    "nombre TEXT NOT NULL)"
        )
        sqLiteDatabase.execSQL(
            "INSERT INTO " + TABLE_SERVICIOS + "(id, nombre) VALUES" +
                    "(1, 'SALA DE JUEGOS'), " +
                    "(2, 'CLUB CASINOCASH')," +
                    "(3, 'RESTAURANTE')"
        )

        sqLiteDatabase.execSQL(
            " CREATE TABLE " + TABLE_USUARIOS + "(" +
                    "id INTEGER PRIMARY KEY NOT NULL," +
                    "dni INTEGER NOT NULL," +
                    "nombre TEXT NOT NULL," +
                    "apellido TEXT NOT NULL," +
                    "ludopata INTEGER NOT NULL," +
                    "correo TEXT NOT NULL," +
                    "celular INTEGER NOT NULL)"
        )
        sqLiteDatabase.execSQL(
            "INSERT INTO " + TABLE_USUARIOS + "(id, dni, nombre, apellido, ludopata, correo, celular) VALUES" +
                    "(1, '11111111', 'Marcos', 'Capcha', 0, 'mcapchaleonardo@gmail.com', 948154228), " +
                    "(2, '22222222', 'Carlos', 'Alcantara', 1, 'calcantara@gmail.com', 933333333)," +
                    "(3, '33333333', 'Angel', 'Ventura', 0, 'aventura@gmail.com', 955555555)," +
                    "(4, '44444444', 'Luis', 'Quintana', 1, 'cquintana@gmail.com', 944444444)"
        )

        sqLiteDatabase.execSQL(
            " CREATE TABLE " + TABLE_REGISTROS + "(" +
                    "id INTEGER PRIMARY KEY NOT NULL," +
                    "pregunta1 INTEGER NOT NULL," +
                    "pregunta2 INTEGER NOT NULL," +
                    "pregunta3 INTEGER NOT NULL," +
                    "pregunta4 INTEGER NOT NULL," +
                    "pregunta5 INTEGER NOT NULL," +
                    "pregunta6 INTEGER NOT NULL," +
                    "pregunta7 INTEGER NOT NULL)"
        )
        sqLiteDatabase.execSQL(
            "INSERT INTO " + TABLE_USUARIOS + "(id, dni, nombre, apellido, ludopata, correo, celular) VALUES" +
                    "(null, null, null, null, null, null, null, null)"
        )

    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCALES)
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SERVICIOS)
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS)
        onCreate(sqLiteDatabase)
    }

    protected val TABLE_LOCALES = "t_locales"
    protected val TABLE_SERVICIOS = "t_servicios"
    protected val TABLE_USUARIOS = "t_usuarios"
    protected val TABLE_REGISTROS = "t_registros"

    companion object {
        private const val BASE_NOMBRE = "db_casino.db"
        private const val BASE_VERSION = 3

    }
}
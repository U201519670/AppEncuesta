package com.example.myproject1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(myContext: Context): SQLiteOpenHelper(myContext,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "dbencuesta.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val sql1 = "CREATE TABLE IF NOT EXISTS colaborador (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, usuario TEXT NOT NULL, clave TEXT NOT NULL, cesado INTEGER)"
        db.execSQL(sql1)
        val sql2 = "CREATE TABLE IF NOT EXISTS cliente (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT NOT NULL, apellidos TEXT NOT NULL, dni TEXT NOT NULL, correo TEXT NOT NULL, celular TEXT NOT NULL, ludopata INTEGER, syncro INTEGER)"
        db.execSQL(sql2)
        val sql3 = "CREATE TABLE IF NOT EXISTS local (id INTEGER PRIMARY KEY AUTOINCREMENT, namelocal TEXT NOT NULL)"
        db.execSQL(sql3)
        val sql4 = "CREATE TABLE IF NOT EXISTS servicio (id INTEGER PRIMARY KEY AUTOINCREMENT, nameservicio TEXT NOT NULL)"
        db.execSQL(sql4)
        val sql5 = "CREATE TABLE IF NOT EXISTS premio (id INTEGER PRIMARY KEY AUTOINCREMENT, codigo TEXT NOT NULL, descripcion TEXT NOT NULL)"
        db.execSQL(sql5)
        val sql6 = "CREATE TABLE IF NOT EXISTS calificacion (idcolaborador INTEGER, puntaje INTEGER, syncro INTEGER)"
        db.execSQL(sql6)
        val sql0 = "CREATE TABLE IF NOT EXISTS ganador (idpremio, idcliente INTEGER ,feasignado TEXT NOT NULL, syncro INTEGER)"
        db.execSQL(sql0)
        val sql7 = "CREATE TABLE IF NOT EXISTS question (id INTEGER PRIMARY KEY AUTOINCREMENT, idservicio INTEGER ,preg TEXT NOT NULL)"
        db.execSQL(sql7)
        val sql8 = "CREATE TABLE IF NOT EXISTS answer (idquestion INTEGER, resp INTEGER, idformulario INTEGER, syncro INTEGER)"
        db.execSQL(sql8)
        val sql9 = "CREATE TABLE IF NOT EXISTS formulario (id INTEGER PRIMARY KEY AUTOINCREMENT, idcolaborador INTEGER, idcliente INTEGER, idlocal INTEGER, idservicio INTEGER, feregistro TEXT NOT NULL, syncro INTEGER)"
        db.execSQL(sql9)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS colaborador")
        db.execSQL("DROP TABLE IF EXISTS cliente")
        db.execSQL("DROP TABLE IF EXISTS local")
        db.execSQL("DROP TABLE IF EXISTS servicio")
        db.execSQL("DROP TABLE IF EXISTS premio")
        db.execSQL("DROP TABLE IF EXISTS calificacion")
        db.execSQL("DROP TABLE IF EXISTS ganador")
        db.execSQL("DROP TABLE IF EXISTS question")
        db.execSQL("DROP TABLE IF EXISTS answer")
        db.execSQL("DROP TABLE IF EXISTS formulario")
        onCreate(db)
    }
}

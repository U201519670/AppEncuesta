package com.example.myproject1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log

class DAOColaborador (myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun buscar(criterio: String): ArrayList<TablaColaborador> {
        val db = dbHelper.readableDatabase
        val lista = ArrayList<TablaColaborador>()
        try {
            val c: Cursor = db.rawQuery(
                "select * from colaborador where usuario = '$criterio'",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val nombre: String = c.getString(c.getColumnIndex("nombre"))
                    val usuario: String = c.getString(c.getColumnIndex("usuario"))
                    val clave: String = c.getString(c.getColumnIndex("clave"))
                    val cesado: Int = c.getInt(c.getColumnIndex("cesado"))
                    val modelo = TablaColaborador()
                    modelo.id = id
                    modelo.nombre = nombre
                    modelo.usuario = usuario
                    modelo.clave = clave
                    modelo.cesado = cesado
                    lista.add(modelo)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOColaborador: Error al buscar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }

}
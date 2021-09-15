package com.example.myproject1

import android.content.Context
import android.database.Cursor

class DAOPremio (myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun buscar(criterio: String): ArrayList<TablaPremio> {
        val db = dbHelper.readableDatabase
        val lista = ArrayList<TablaPremio>()
        try {
            val c: Cursor = db.rawQuery(
                "select * from premio where id = '$criterio'",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val codigo: String = c.getString(c.getColumnIndex("codigo"))
                    val descripcion: String = c.getString(c.getColumnIndex("descripcion"))
                    val modelo = TablaPremio()
                    modelo.id = id
                    modelo.codigo = codigo
                    modelo.descripcion = descripcion
                    lista.add(modelo)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOPremio: Error al buscar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }


    fun obtener(): TablaPremio {
        val db = dbHelper.readableDatabase
        val modelo = TablaPremio()
        try {
            val c: Cursor = db.rawQuery("select * from premio", null)
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val codigo: String = c.getString(c.getColumnIndex("codigo"))
                    val descripcion: String = c.getString(c.getColumnIndex("descripcion"))
                    modelo.id = id
                    modelo.codigo = codigo
                    modelo.descripcion = descripcion
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOPremio: Error al obtener: " + e.message)
        } finally {
            db.close()
        }
        return modelo
    }

}
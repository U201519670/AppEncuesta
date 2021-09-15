package com.example.myproject1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log

class DAOLocal (myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun buscar(criterio: String): ArrayList<TablaLocal> {
        val db = dbHelper.readableDatabase
        val lista = ArrayList<TablaLocal>()
        try {
            val c: Cursor = db.rawQuery(
                "select * from local where id = '$criterio'",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val namelocal: String = c.getString(c.getColumnIndex("namelocal"))
                    val modelo = TablaLocal()
                    modelo.id = id
                    modelo.namelocal = namelocal
                    lista.add(modelo)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOLocal: Error al buscar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }

    fun obtener(): TablaLocal {
        val db = dbHelper.readableDatabase
        val modelo = TablaLocal()
        try {
            val c: Cursor = db.rawQuery("select * from local", null)
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val namelocal: String = c.getString(c.getColumnIndex("namelocal"))
                    modelo.id = id
                    modelo.namelocal = namelocal
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOLocal: Error al obtener: " + e.message)
        } finally {
            db.close()
        }
        return modelo
    }

}
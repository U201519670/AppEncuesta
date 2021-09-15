package com.example.myproject1

import android.content.Context
import android.database.Cursor

class DAOServicio (myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun buscar(criterio: String): ArrayList<TablaServicio> {
        val db = dbHelper.readableDatabase
        val lista = ArrayList<TablaServicio>()
        try {
            val c: Cursor = db.rawQuery(
                "select * from servicio where id = '$criterio'",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val nameservicio: String = c.getString(c.getColumnIndex("nameservicio"))
                    val modelo = TablaServicio()
                    modelo.id = id
                    modelo.nameservicio = nameservicio
                    lista.add(modelo)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOServicio: Error al buscar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }


    fun obtener(): TablaServicio {
        val db = dbHelper.readableDatabase
        val modelo = TablaServicio()
        try {
            val c: Cursor = db.rawQuery("select * from servicio", null)
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val nameservicio: String = c.getString(c.getColumnIndex("nameservicio"))
                    modelo.id = id
                    modelo.nameservicio = nameservicio
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOServicio: Error al obtener: " + e.message)
        } finally {
            db.close()
        }
        return modelo
    }

}
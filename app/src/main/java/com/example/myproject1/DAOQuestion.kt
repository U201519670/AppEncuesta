package com.example.myproject1

import android.content.Context
import android.database.Cursor

class DAOQuestion (myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun buscar(criterio: String): ArrayList<TablaQuestion> {
        val db = dbHelper.readableDatabase
        val lista = ArrayList<TablaQuestion>()
        try {
            val c: Cursor = db.rawQuery(
                "select * from question where id = '$criterio'",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val idservicio: Int = c.getInt(c.getColumnIndex("idservicio"))
                    val preg: String = c.getString(c.getColumnIndex("preg"))
                    val modelo = TablaQuestion()
                    modelo.id = id
                    modelo.idservicio = idservicio
                    modelo.preg = preg
                    lista.add(modelo)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOQuestion: Error al buscar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }


    fun obtener(): TablaQuestion {
        val db = dbHelper.readableDatabase
        val modelo = TablaQuestion()
        try {
            val c: Cursor = db.rawQuery("select * from question", null)
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val idservicio: Int = c.getInt(c.getColumnIndex("idservicio"))
                    val preg: String = c.getString(c.getColumnIndex("preg"))
                    modelo.id = id
                    modelo.idservicio = idservicio
                    modelo.preg = preg
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOQuestion: Error al obtener: " + e.message)
        } finally {
            db.close()
        }
        return modelo
    }

}
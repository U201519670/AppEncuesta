package com.example.myproject1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class DAOCalificacion (myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun buscar(criterio: String): ArrayList<TablaCalificacion> {
        val db = dbHelper.readableDatabase
        val lista = ArrayList<TablaCalificacion>()
        try {
            val c: Cursor = db.rawQuery(
                "select * from calificacion where idcolaborador = '$criterio'",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val idcolaborador: Int = c.getInt(c.getColumnIndex("idcolaborador"))
                    val puntaje: Int = c.getInt(c.getColumnIndex("puntaje"))
                    val syncro: Int = c.getInt(c.getColumnIndex("syncro"))
                    val modelo = TablaCalificacion()
                    modelo.idcolaborador = idcolaborador
                    modelo.puntaje = puntaje
                    modelo.syncro = syncro
                    lista.add(modelo)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOCalificacion: Error al buscar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }

    fun insertar(idcolaborador: Int, puntaje: Int) : Long {
        val indice: Long
        val values = ContentValues().apply {
            put("idcolaborador", idcolaborador)
            put("puntaje", puntaje)
            put("syncro", 0)
        }
        val db = dbHelper.writableDatabase
        try {
            indice = db.insert("calificacion",null, values)
            return indice
        } catch (e: Exception) {
            throw DAOException("DAOCalificacion: Error al insertar: " + e.message)
        } finally {
            db.close()
        }
    }

}
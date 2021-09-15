package com.example.myproject1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class DAOAnswer (myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun buscar(criterio: Int): ArrayList<TablaAnswer> {
        val db = dbHelper.readableDatabase
        val lista = ArrayList<TablaAnswer>()
        try {
            val c: Cursor = db.rawQuery(
                "select * from answer where idformulario = '$criterio'",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val idquestion: Int = c.getInt(c.getColumnIndex("idquestion"))
                    val resp: Int = c.getInt(c.getColumnIndex("resp"))
                    val idformulario: Int = c.getInt(c.getColumnIndex("idformulario"))
                    val syncro: Int = c.getInt(c.getColumnIndex("syncro"))
                    val modelo = TablaAnswer()
                    modelo.idquestion = idquestion
                    modelo.resp = resp
                    modelo.idformulario = idformulario
                    modelo.syncro = syncro
                    lista.add(modelo)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOAnswer: Error al buscar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }

    fun insertar(idquestion: Int, puntaje: Int, idformulario: Int) : Long {
        val indice: Long
        val values = ContentValues().apply {
            put("idquestion", idquestion)
            put("puntaje", puntaje)
            put("idformulario", idformulario)
            put("syncro", 0)
        }
        val db = dbHelper.writableDatabase
        try {
            indice = db.insert("answer",null, values)
            return indice
        } catch (e: Exception) {
            throw DAOException("DAOAnswer: Error al insertar: " + e.message)
        } finally {
            db.close()
        }
    }

}
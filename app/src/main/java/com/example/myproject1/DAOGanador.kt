package com.example.myproject1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class DAOGanador (myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun buscar(criterio: String): ArrayList<TablaGanador> {
        val db = dbHelper.readableDatabase
        val lista = ArrayList<TablaGanador>()
        try {
            val c: Cursor = db.rawQuery(
                "select * from ganador where idpremio = '$criterio'",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val idpremio: Int = c.getInt(c.getColumnIndex("idpremio"))
                    val idcliente: Int = c.getInt(c.getColumnIndex("idcliente"))
                    val feasignado: String = c.getString(c.getColumnIndex("feasignado"))
                    val syncro: Int = c.getInt(c.getColumnIndex("syncro"))
                    val modelo = TablaGanador()
                    modelo.idpremio = idpremio
                    modelo.idcliente = idcliente
                    modelo.feasignado = feasignado
                    modelo.syncro = syncro
                    lista.add(modelo)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOGanador: Error al buscar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }

    fun insertar(idpremio: Int, idcliente: Int, feasignado: String) : Long {
        val indice: Long
        val values = ContentValues().apply {
            put("idpremio", idpremio)
            put("idcliente", idcliente)
            put("feasignado",feasignado)
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
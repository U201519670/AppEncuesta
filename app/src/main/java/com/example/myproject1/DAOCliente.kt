package com.example.myproject1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log

class DAOCliente (myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun buscar(criterio: String): ArrayList<TablaCliente> {
        val db = dbHelper.readableDatabase
        val lista = ArrayList<TablaCliente>()
        try {
            val c: Cursor = db.rawQuery(
                "select * from cliente where dni = '$criterio'",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val nombres: String = c.getString(c.getColumnIndex("nombres"))
                    val apellidos: String = c.getString(c.getColumnIndex("apellidos"))
                    val dni: String = c.getString(c.getColumnIndex("dni"))
                    val correo: String = c.getString(c.getColumnIndex("correo"))
                    val celular: String = c.getString(c.getColumnIndex("celular"))
                    val ludopata: Int = c.getInt(c.getColumnIndex("ludopata"))
                    val syncro: Int = c.getInt(c.getColumnIndex("syncro"))
                    val modelo = TablaCliente()
                    modelo.id = id
                    modelo.nombres = nombres
                    modelo.apellidos = apellidos
                    modelo.dni = dni
                    modelo.correo = correo
                    modelo.celular = celular
                    modelo.ludopata = ludopata
                    modelo.syncro = syncro
                    lista.add(modelo)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOCliente: Error al buscar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }

    fun insertar(nombres: String, apellidos: String, dni: String, correo: String, celular: String): Long {
        val indice: Long
        val values = ContentValues().apply {
            put("nombres", nombres)
            put("apellidos", apellidos)
            put("dni", dni)
            put("correo", correo)
            put("celular", celular)
            put("ludopata", 0)
            put("syncro", 0)
        }
        val db = dbHelper.writableDatabase
        try {
            indice = db.insert("cliente",null, values)
            return indice
        } catch (e: Exception) {
            throw DAOException("DAOCliente: Error al insertar: " + e.message)
        } finally {
            db.close()
        }
    }

}
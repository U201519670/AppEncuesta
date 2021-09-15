package com.example.myproject1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class DAOFormulario (myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun buscar(criterio: Int): ArrayList<TablaFormulario> {
        val db = dbHelper.readableDatabase
        val lista = ArrayList<TablaFormulario>()
        try {
            val c: Cursor = db.rawQuery(
                "select * from formulario where id = '$criterio'",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val idcolaborador: Int = c.getInt(c.getColumnIndex("idcolaborador"))
                    val idcliente: Int = c.getInt(c.getColumnIndex("idcliente"))
                    val idlocal: Int = c.getInt(c.getColumnIndex("idlocal"))
                    val idservicio: Int = c.getInt(c.getColumnIndex("idservicio"))
                    val feregistro: String = c.getString(c.getColumnIndex("feregistro"))
                    val syncro: Int = c.getInt(c.getColumnIndex("syncro"))
                    val modelo = TablaFormulario()
                    modelo.id = id
                    modelo.idcolaborador = idcolaborador
                    modelo.idcliente = idcliente
                    modelo.idlocal = idlocal
                    modelo.idservicio = idservicio
                    modelo.feregistro = feregistro
                    modelo.syncro = syncro
                    lista.add(modelo)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DAOFormulario: Error al buscar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }

    fun insertar(idcolaborador: Int, idcliente: Int, idlocal: Int, idservicio: Int, feregistro: String) : Long {
        val indice: Long
        val values = ContentValues().apply {
            put("idcolaborador", idcolaborador)
            put("idcliente", idcliente)
            put("idlocal", idlocal)
            put("idservicio", idservicio)
            put("feregistro", feregistro)
            put("syncro", 0)
        }
        val db = dbHelper.writableDatabase
        try {
            indice = db.insert("formulario",null, values)
            return indice
        } catch (e: Exception) {
            throw DAOException("DAOFormulario: Error al insertar: " + e.message)
        } finally {
            db.close()
        }
    }

}
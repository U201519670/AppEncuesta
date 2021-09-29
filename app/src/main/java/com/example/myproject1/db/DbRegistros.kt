package com.example.myproject1.db

import android.content.Context
import android.database.Cursor
import java.lang.Exception

class DbRegistros(context: Context?, i: Int) : Helper(context, String(), null, 7) {
    fun mostarRegistros(): Cursor? {
        return try {
            val bd = this.readableDatabase
            val filas = bd.rawQuery("SELECT * FROM " + TABLE_REGISTROS + "", null)
            if (filas.moveToFirst()) {
                filas
            } else {
                null
            }
        } catch (ex: Exception) {
            null
        }
    }
}
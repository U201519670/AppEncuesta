package com.example.myproject1.db

import android.content.Context
import android.database.Cursor
import java.lang.Exception

class DbUsuarios(context: Context?) : Helper(context, String(), null, 7) {
    fun mostarUsuarios(): Cursor? {
        return try {
            val bd = this.readableDatabase
            val filas = bd.rawQuery("SELECT * FROM " + TABLE_USUARIOS + "", null)
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
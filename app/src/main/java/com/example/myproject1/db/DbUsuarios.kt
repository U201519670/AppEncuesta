package com.example.myproject1.db

import android.content.Context
import android.database.Cursor
import com.example.myproject1.db.Helper
import android.database.sqlite.SQLiteDatabase
import java.lang.Exception

class DbUsuarios(context: Context?) : Helper(context) {
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
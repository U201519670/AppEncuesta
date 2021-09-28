package com.example.myproject1.db

import android.content.Context
import android.database.Cursor
import com.example.myproject1.db.Helper
import android.database.sqlite.SQLiteDatabase
import java.lang.Exception

class DbServicios(context: Context?) : Helper(context) {
    fun mostarServicios(): Cursor? {
        return try {
            val bd = this.readableDatabase
            val filas = bd.rawQuery("SELECT * FROM $TABLE_SERVICIOS", null)
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
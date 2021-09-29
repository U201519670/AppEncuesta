package com.example.myproject1.db

import android.content.Context
import android.database.Cursor
import java.lang.Exception

class DbLocales(context: Context?) : Helper(context, String(), null, 7) {
    fun mostarLocales(): Cursor? {
        return try {
            val bd = this.readableDatabase
            val filas = bd.rawQuery("SELECT * FROM " + TABLE_LOCALES + "", null)
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
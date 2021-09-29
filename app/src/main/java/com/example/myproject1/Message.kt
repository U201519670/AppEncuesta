package com.example.myproject1

import android.content.Context
import android.widget.Toast

object Message {
    fun message(context: Context?, msg: String?) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}
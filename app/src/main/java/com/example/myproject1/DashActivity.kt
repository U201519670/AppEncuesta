package com.example.myproject1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_dash.*
import kotlinx.android.synthetic.main.activity_datos_clientes.*
import android.R.id
import android.widget.TextView
import android.view.View
import android.widget.EditText


class DashActivity : AppCompatActivity() {

    private var textView16: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        textView16 = findViewById<View>(R.id.textView16) as TextView
        val parametros = intent.extras
        if (parametros != null) {
            textView16!!.text = parametros.getString("Servicios")
        }

        linearLayout_2.setOnClickListener {
            startActivity(Intent(this, DatosClientesActivity::class.java))
        }

        linearLayout_4.setOnClickListener {
            startActivity(Intent(this, ServiciosActivity::class.java))
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_dash_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_dash -> {
                startActivity(Intent(this,MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
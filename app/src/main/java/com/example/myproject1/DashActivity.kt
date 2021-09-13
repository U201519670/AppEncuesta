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
import android.content.Context
import android.widget.TextView
import android.view.View
import android.widget.EditText


class DashActivity : AppCompatActivity() {

    private var textView16: TextView? = null
    private var textView12: TextView? = null
    private var textView13: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        linearLayout_3.setOnClickListener {
            startActivity(Intent(this, DatosClientesActivity::class.java))
        }

        linearLayout_5.setOnClickListener {
            startActivity(Intent(this, ServiciosActivity::class.java))
        }

        textView16 = findViewById<View>(R.id.textView16) as TextView
        val editor = intent.getStringExtra("MY_SHARED_PREF")
        if (editor != null) {
            textView16!!.text = editor
        }

        textView12 = findViewById<View>(R.id.textView12) as TextView
        val nombres = intent.getStringExtra("nombres")
        if (nombres != null) {
            textView12!!.text = nombres
        }

        textView13 = findViewById<View>(R.id.textView13) as TextView
        val dni = intent.getStringExtra("dni")
        if (dni != null) {
            textView13!!.text = dni
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

    override fun onStart() {
        super.onStart()

    }

    override fun onResume() {
        super.onResume()

    }

    fun mostrarDato() {


    }

    override fun onPause() {
        super.onPause()

    }

    override fun onStop() {
        super.onStop()

    }

    override fun onRestart() {
        super.onRestart()

    }

    override fun onDestroy() {
        super.onDestroy()

    }
}
package com.example.myproject1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

class GoodbyeActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goodbye)


        val btngiro: Button = this.findViewById(R.id.btn_giroruleta)
        btngiro.setOnClickListener(this)
        btngiro.setBackgroundColor(Color.CYAN)
        val btncalificacion: Button = this.findViewById(R.id.btn_calificacion)
        btncalificacion.setOnClickListener(this)
        val btnenviar: Button = this.findViewById(R.id.btn_enviar)
        btnenviar.setOnClickListener(this)
        val btnfinalizar: Button = this.findViewById(R.id.btn_finalizar)
        btnfinalizar.setOnClickListener(this)
        return
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_goodbye_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_dash -> {
                startActivity(Intent(this,RegaloUser::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_giroruleta -> startActivity(Intent(this, RegaloUser::class.java))
        }
        when (p0?.id) {
            R.id.btn_calificacion -> startActivity(Intent(this, CalificacionUser::class.java))
        }
        when (p0?.id) {
            R.id.btn_enviar -> startActivity(Intent(this, EnviarCorreo::class.java))
        }
        when (p0?.id) {
            R.id.btn_finalizar -> startActivity(Intent(this, MainActivity::class.java))
        }
    }

}
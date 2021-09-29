package com.example.myproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class EnviarCorreo : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_correo)

        val btnfinalizar: Button = this.findViewById(R.id.btnregresar)
        btnfinalizar.setOnClickListener(this)
        return
    }


    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.btn_finalizar -> startActivity(Intent(this, MainActivity::class.java))
        }
    }

}
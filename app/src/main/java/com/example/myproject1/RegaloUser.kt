package com.example.myproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_regalo_user.*
import kotlinx.android.synthetic.main.nav_header_main.*
import java.util.*



class RegaloUser : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalo_user)
        val imagen = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.imageView7)
        imagen.setImageResource(R.drawable.regalocerrado)


        var numero= (1..60).random()
        Log.i("-->", numero.toString())
        var premio=""
        if(numero>=1&&numero<10) {
            premio = "ACG60812-SD"
        }else if(numero>=10 &&numero<20) {
            premio = "SIGUE INTENTANDO"
        }else if(numero>=20 &&numero<30) {
            premio = "A65D21F2-22"
        }else if(numero>30 &&numero<40) {
            premio = "SIGUE INTENTANDO"
        }else if(numero>40 &&numero<50) {
            premio = "GSFG2DFS-50"
        }else{
            premio = "SIGUE INTENTANDO"
        }

        btn_abrir.setOnClickListener {
            mostrarpremio.text=premio
            imagen.setImageResource(R.drawable.regaloabierto)
        }

        btnsalir.setOnClickListener {
            startActivity(Intent(this, GoodbyeActivity::class.java))


        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}
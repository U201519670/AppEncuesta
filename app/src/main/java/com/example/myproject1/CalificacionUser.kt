package com.example.myproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calificacion_user.*

class CalificacionUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificacion_user)


        ratingBar.setOnRatingBarChangeListener { ratingBar, f1 , b->
            textrating.text="rating:"+f1.toString()
        }



        btn_calificar.setOnClickListener {


            startActivity(Intent(this, GoodbyeActivity::class.java))
        }
    }
}
package com.example.myproject1

import android.content.Intent
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_calificacion_user.*
import org.w3c.dom.Text
import kotlin.math.log

class CalificacionUser : AppCompatActivity() , View.OnClickListener{



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificacion_user)


        ratingBar.setOnRatingBarChangeListener { ratingBar, f1 , b->
            textrating.text=f1.toString()
        }

       btn_calificar.setOnClickListener {

       }
         //   startActivity(Intent(this, GoodbyeActivity::class.java))
      //  }

    }

    fun calificar(view: View){
        val idcolaborador=15
        val calificacion=ratingBar.getRating().toInt()


        val dao=DAOCalificacion(baseContext)
        try {
            val indice=dao.insertar(idcolaborador,calificacion)
            if(indice>0){
                Toast.makeText(baseContext, "Se califico correctamente", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, GoodbyeActivity::class.java))
            }else{
                Toast.makeText(baseContext, "hubo un error, intente nuevamente", Toast.LENGTH_SHORT).show()
        }

            }catch (e: DAOException){
              e.message }



    }

    override fun onClick(v: View?) {

    }
}
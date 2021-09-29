package com.example.myproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_regalo_user.*
import kotlinx.android.synthetic.main.nav_header_main.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*



class RegaloUser : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalo_user)
        val imagen = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.imageView7)
        imagen.setImageResource(R.drawable.regalocerrado)


        btn_abrir.setOnClickListener {
            imagen.setImageResource(R.drawable.regaloabierto)

            var numero = (1..25).random()
            val queue = Volley.newRequestQueue(this)

            val criterio = numero
            val url = "https://aat.com.pe/encuesta/index.php/premio/$criterio"
            val stringRequest = StringRequest(Request.Method.GET, url, { response ->
                val jsonArray=JSONArray(response)
                for (i in 0 until jsonArray.length()){
                    val jsonObject= JSONObject(jsonArray.getString(i))
                    var premio=jsonObject.get("nombre")
                    var descripcion=jsonObject.get("descripcion")
                    mostrarpremio.text=premio.toString()
                    iddescripcion.text=descripcion.toString()


                }

                val jsonObject=jsonArray[0]

            }, {
                    error ->
            })


            queue.add(stringRequest)


        }

        btnsalir.setOnClickListener {
            startActivity(Intent(this, GoodbyeActivity::class.java))


        }
    }





    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}
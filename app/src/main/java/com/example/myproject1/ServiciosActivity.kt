package com.example.myproject1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.nav_header_main.*


class ServiciosActivity : AppCompatActivity(), OnItemClickListener  {

    private var lista_servicios: ListView? = null
    private val datos = arrayOf("SALA DE JUEGO", "CLUB CASINOCASH", "RESTAURANTE")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios)
        lista_servicios = findViewById<View>(R.id.lista_servicios) as ListView
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, datos)
        lista_servicios!!.onItemClickListener = this
        lista_servicios!!.adapter = adaptador

        /**val arrayAdapter:ArrayAdapter<*>

        val servicios = mutableListOf("SALA DE JUEGO", "CLUB CASINOCASH", "RESTAURANTE")
        val lista_servicios = findViewById<ListView>(R.id.lista_servicios)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, servicios)
        lista_servicios.adapter = adaptador

        lista_servicios.onItemClickListener = OnItemClickListener {
                parent, view, position, id ->
            val selectedItemText = parent.getItemAtPosition(position)
            textView.text = "Selected : $selectedItemText"
        }

        //lista_servicios.setOnItemClickListener(){parent,view,position,id->

        //    Toast.makeText(this, parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show()

        //}**/

    }

    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        val valor = adapterView.getItemAtPosition(i) as String
        val nuevoform = Intent(this@ServiciosActivity, DashActivity::class.java)
        nuevoform.putExtra("Servicios", valor)
        startActivity(nuevoform)
    }

}
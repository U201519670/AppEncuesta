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
import android.location.Location
import android.view.View
import android.widget.*
import com.example.myproject1.db.DbLocales
import com.example.myproject1.entidades.Locales
import com.example.myproject1.db.DbServicios
import com.example.myproject1.entidades.Servicios
import java.util.*


class DashActivity : AppCompatActivity(), View.OnClickListener {

    private var textView12: TextView? = null
    private var textView13: TextView? = null
    var spLocales: Spinner? = null
    var spServicios: Spinner? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        // Spinner de los tipos de Locales
        spLocales = findViewById(R.id.spLocales)
        val listaLocales = llenarLocales()
        val arrayAdapterLocal = ArrayAdapter(
            applicationContext,
            R.layout.support_simple_spinner_dropdown_item,
            listaLocales
        )
        spLocales.run {
            this?.setAdapter(arrayAdapterLocal)
        }

        spLocales?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                val idLoc = (adapterView.selectedItem as Locales).id
                val nombreLoc = (adapterView.selectedItem as Locales).nombre
                Toast.makeText(this@DashActivity, "$idLoc - $nombreLoc", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        //Spinner de los tipo de servicios
        spServicios = findViewById(R.id.spServicios)
        val listaServicios = llenarServicios()
        val arrayAdapterServicios = ArrayAdapter(
            applicationContext,
            R.layout.support_simple_spinner_dropdown_item,
            listaServicios
        )
        spServicios.run {
            this?.setAdapter(arrayAdapterServicios)
        }
        spServicios?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                val idSer = (adapterView.selectedItem as Servicios).id
                val nombreSer = (adapterView.selectedItem as Servicios).nombre
                Toast.makeText(this@DashActivity, "$idSer - $nombreSer", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        /**Spinner de Locales
        val spinner = findViewById<Spinner>(R.id.spnLocales)

        //val lista = listOf("PHP", "C++","SQL", "Java")

        val lista = resources.getStringArray(R.array.locales)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador

        spinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@DashActivity,lista[position],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //Spinner de Servicios
        val spinner2 = findViewById<Spinner>(R.id.spnServicios)

        //val lista = listOf("PHP", "C++","SQL", "Java")

        val lista2 = resources.getStringArray(R.array.servicios)

        val adaptador2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista2)
        spinner2.adapter = adaptador2

        spinner2.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val position = position
                Toast.makeText(this@DashActivity,lista2[position],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }**/

        linearLayout_3.setOnClickListener {
            startActivity(Intent(this, DatosClientesActivity::class.java))
        }

        /**linearLayout_5.setOnClickListener {
            startActivity(Intent(this, ServiciosActivity::class.java))
        }

        textView16 = findViewById<View>(R.id.textView16) as TextView
        val editor = intent.getStringExtra("MY_SHARED_PREF")
        if (editor != null) {
            textView16!!.text = editor
        }**/

        textView12 = findViewById<View>(R.id.textView12) as TextView
        val apellidos = intent.getStringExtra("apellidos")
        val nombres = intent.getStringExtra("nombres")
        if (nombres != null) {
            textView12!!.text = nombres+ " " + apellidos
        }

        textView13 = findViewById<View>(R.id.textView13) as TextView
        val dni = intent.getStringExtra("dni")
        if (dni != null) {
            textView13!!.text = dni
        }

        val btnform: Button = this.findViewById(R.id.botonform)
        btnform.setOnClickListener(this)
        return
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

    override fun onClick(p0: View?) {
        when(p0?.id)
        {

            R.id.botonform -> startActivity(Intent(this,SalaDeJuego::class.java))
        }
    }

    private fun llenarLocales(): List<Locales> {
        val listaLoc: MutableList<Locales> = ArrayList()
        val dbLocales = DbLocales(this@DashActivity)
        val cursor = dbLocales.mostarLocales()
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val loc = Locales()
                    loc.id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                    loc.nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                    listaLoc.add(loc)
                } while (cursor.moveToNext())
            }
        }
        dbLocales.close()
        return listaLoc
    }

    private fun llenarServicios(): List<Servicios> {
        val listaSer: MutableList<Servicios> = ArrayList()
        val dbServicios = DbServicios(this@DashActivity)
        val cursor = dbServicios.mostarServicios()
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val ser = Servicios()
                    ser.id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                    ser.nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                    listaSer.add(ser)
                } while (cursor.moveToNext())
            }
        }
        dbServicios.close()
        return listaSer
    }

}
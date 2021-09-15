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


class DashActivity : AppCompatActivity(), View.OnClickListener {

    //private var textView16: TextView? = null
    private var textView12: TextView? = null
    private var textView13: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        //Spinner de Locales
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

        }

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
        val nombres = intent.getStringExtra("nombres")
        if (nombres != null) {
            textView12!!.text = nombres
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
            R.id.botonform -> startActivity(Intent(this,FormActivity::class.java))
        }
    }

}
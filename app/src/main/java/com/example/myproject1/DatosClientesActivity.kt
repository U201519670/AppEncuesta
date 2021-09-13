package com.example.myproject1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_datos_clientes.*

class DatosClientesActivity : AppCompatActivity() {

    private var dni: EditText? = null
    private var nombres: EditText? = null
    private var apellidos: EditText? = null
    private var correo: EditText? = null
    private var celular: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_clientes)

        dni = findViewById<View>(R.id.editTextNumber) as EditText
        nombres = findViewById<View>(R.id.editTextTextPersonName) as EditText
        apellidos = findViewById<View>(R.id.editTextTextPersonName2) as EditText
        correo = findViewById<View>(R.id.editTextTextEmailAddress2) as EditText
        celular = findViewById<View>(R.id.editTextNumber2) as EditText
        val preferences = getSharedPreferences("dni", MODE_PRIVATE)
        dni!!.setText(preferences.getString("dni", ""))
        val preferences1 = getSharedPreferences("nombres", MODE_PRIVATE)
        nombres!!.setText(preferences.getString("nombres", ""))
        val preferences2 = getSharedPreferences("apellidos", MODE_PRIVATE)
        apellidos!!.setText(preferences.getString("apellidos", ""))
        val preferences3 = getSharedPreferences("correo", MODE_PRIVATE)
        correo!!.setText(preferences.getString("correo", ""))
        val preferences4 = getSharedPreferences("celular", MODE_PRIVATE)
        celular!!.setText(preferences.getString("celular", ""))
    }

    //Metodo para el botón guardar
    fun GuardarDatos(view: View?) {
        val preferencias = getSharedPreferences("dni", MODE_PRIVATE)
        val Obj_editarCliente = preferencias.edit()
        Obj_editarCliente.putString("dni", dni!!.text.toString())
        val preferencias1 = getSharedPreferences("nombres", MODE_PRIVATE)
        val Obj_editarCliente1 = preferencias.edit()
        Obj_editarCliente1.putString("nombres", nombres!!.text.toString())
        val preferencias2 = getSharedPreferences("apellidos", MODE_PRIVATE)
        val Obj_editarCliente2 = preferencias.edit()
        Obj_editarCliente2.putString("apellidos", apellidos!!.text.toString())
        val preferencias3 = getSharedPreferences("correo", MODE_PRIVATE)
        val Obj_editarCliente3 = preferencias.edit()
        Obj_editarCliente3.putString("correo", correo!!.text.toString())
        val preferencias4 = getSharedPreferences("celular", MODE_PRIVATE)
        val Obj_editarCliente4 = preferencias.edit()
        Obj_editarCliente4.putString("celular", celular!!.text.toString())
        Obj_editarCliente.commit()
        Obj_editarCliente1.commit()
        Obj_editarCliente2.commit()
        Obj_editarCliente3.commit()
        Obj_editarCliente4.commit()
        startActivity(Intent(this, DashActivity::class.java))
        val i = Intent(this, DashActivity::class.java)
        i.putExtra("dni", dni!!.text.toString())
        i.putExtra("nombres", nombres!!.text.toString())
        i.putExtra("apellidos", apellidos!!.text.toString())
        i.putExtra("correo", correo!!.text.toString())
        i.putExtra("celular", celular!!.text.toString())
        startActivity(i)
    }

    //Metodo para el botón enviar

}
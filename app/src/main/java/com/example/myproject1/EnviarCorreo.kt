package com.example.myproject1

import android.Manifest
import android.Manifest.permission.SEND_SMS
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager

import android.view.View
import android.widget.Button
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_calificacion_user.*
import kotlinx.android.synthetic.main.activity_enviar_correo.*
import android.content.pm.PackageManager
import android.util.Log

import androidx.core.content.ContextCompat




class EnviarCorreo : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_correo)





        val btnfinalizar: Button = this.findViewById(R.id.btnregresar)
        btnfinalizar.setOnClickListener(this)
        return

        btnenviar3.setOnClickListener {
            enviarmensaje("963760824")
        }
    }

    fun enviarmensaje(telefono:String){
            var numero=telefono
            var sms=SmsManager.getDefault();
            var mensaje1="Te recomedo tu amigo Juan , ganaste un premio de 10% en tu primera compra de fichas.visitanos en nuestro local de Miraflores"
            sms.sendTextMessage(numero,null,mensaje1,null,null);



    }
    private fun checkSMSStatePermission() {
        val permissionCheck = ContextCompat.checkSelfPermission(
            this, Manifest.permission.SEND_SMS
        )
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para enviar SMS.")
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), 225)
        } else {
            Log.i("Mensaje", "Se tiene permiso para enviar SMS!")
        }
    }


    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.btn_finalizar -> startActivity(Intent(this, MainActivity::class.java))
        }
    }

}
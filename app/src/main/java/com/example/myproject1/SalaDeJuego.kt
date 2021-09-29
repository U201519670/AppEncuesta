package com.example.myproject1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_dash.*

class SalaDeJuego : AppCompatActivity(), RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    var rg_sj_1:RadioGroup? = null
    var rg_sj_2:RadioGroup? = null
    var rg_sj_3:RadioGroup? = null
    var rg_sj_4:RadioGroup? = null
    var rg_sj_5:RadioGroup? = null
    var rg_sj_6:RadioGroup? = null
    var rg_sj_7:RadioGroup? = null
    var btnGuardar:Button? = null
    var btnLimpiar:Button? = null
    /**var id_enc:String? = null
    var pre1:String? = null
    var pre2:String? = null
    var pre3:String? = null
    var pre4:String? = null
    var pre5:String? = null
    var pre6:String? = null
    var pre7:String? = null
    var contenedor:EditText? = null
    var contenedor1:EditText? = null
    var contenedor2:EditText? = null
    var contenedor3:EditText? = null
    var contenedor4:EditText? = null
    var contenedor5:EditText? = null
    var contenedor6:EditText? = null**/
    var id_encuesta:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sala_de_juego)

        rg_sj_1 = findViewById(R.id.rg_sj_1)
        rg_sj_2 = findViewById(R.id.rg_sj_2)
        rg_sj_3 = findViewById(R.id.rg_sj_3)
        rg_sj_4 = findViewById(R.id.rg_sj_4)
        rg_sj_5 = findViewById(R.id.rg_sj_5)
        rg_sj_6 = findViewById(R.id.rg_sj_6)
        rg_sj_7= findViewById(R.id.rg_sj_7)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnLimpiar = findViewById(R.id.btnLimpiar)


        btnGuardar?.setOnClickListener {
            val checkedId = rg_sj_1?.checkedRadioButtonId
            if (checkedId == -1) {
                Message.message(applicationContext, "Selecciona un puntaje de la P1")
            } else {
                if (checkedId != null) {
                    findRadioButton(checkedId)
                }
            }
            val checkedId2 = rg_sj_2?.checkedRadioButtonId
            if (checkedId2 == -1) {
                Message.message(applicationContext, "Selecciona un puntaje de la P2")
            } else {
                if (checkedId2 != null) {
                    findRadioButton2(checkedId2)
                }
            }
            val checkedId3 = rg_sj_3?.checkedRadioButtonId
            if (checkedId3 == -1) {
                Message.message(applicationContext, "Selecciona un puntaje de la P3")
            } else {
                if (checkedId3 != null) {
                    findRadioButton3(checkedId3)
                }
            }
            val checkedId4 = rg_sj_4?.checkedRadioButtonId
            if (checkedId4 == -1) {
                Message.message(applicationContext, "Selecciona un puntaje de la P4")
            } else {
                if (checkedId4 != null) {
                    findRadioButton4(checkedId4)
                }
            }
            val checkedId5 = rg_sj_5?.checkedRadioButtonId
            if (checkedId5 == -1) {
                Message.message(applicationContext, "Selecciona un puntaje de la P5")
            } else {
                if (checkedId5 != null) {
                    findRadioButton5(checkedId5)
                }
            }
            val checkedId6 = rg_sj_6?.checkedRadioButtonId
            if (checkedId6 == -1) {
                Message.message(applicationContext, "Selecciona un puntaje de la P6")
            } else {
                if (checkedId6 != null) {
                    findRadioButton6(checkedId6)
                }
            }
            val checkedId7 = rg_sj_7?.checkedRadioButtonId
            if (checkedId7 == -1) {
                Message.message(applicationContext, "Selecciona un puntaje de la P7")
            } else {
                if (checkedId7 != null) {
                    findRadioButton7(checkedId7)
                    btnGuardar?.setOnClickListener {
                        startActivity(Intent(this, GoodbyeActivity::class.java))
                    }
                }
            }

        }
        btnLimpiar?.setOnClickListener {
            rg_sj_1?.clearCheck()
            rg_sj_2?.clearCheck()
            rg_sj_3?.clearCheck()
            rg_sj_4?.clearCheck()
            rg_sj_5?.clearCheck()
            rg_sj_6?.clearCheck()
            rg_sj_7?.clearCheck()


        }

        rg_sj_1?.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            fun onCheckedChange(checkedId: Int) {
                findRadioButton(checkedId)
            }

            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId){
                    R.id.sj_p1_1 -> Message.message(applicationContext, "Definitivamente No")
                    R.id.sj_p1_2 -> Message.message(applicationContext, "Poco Probable")
                    R.id.sj_p1_3 -> Message.message(applicationContext, "Probable")
                    R.id.sj_p1_4 -> Message.message(applicationContext, "Muy Probable")
                    R.id.sj_p1_5 -> Message.message(applicationContext, "Definitivamente Si")
                }
            }
        })

        rg_sj_2?.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            fun onCheckedChange(checkedId2: Int) {
                findRadioButton2(checkedId2)
            }

            override fun onCheckedChanged(group: RadioGroup?, checkedId2: Int) {
                when (checkedId2){
                    R.id.sj_p2_1 -> Message.message(applicationContext, "Definitivamente No")
                    R.id.sj_p2_2 -> Message.message(applicationContext, "Poco Probable")
                    R.id.sj_p2_3 -> Message.message(applicationContext, "Probable")
                    R.id.sj_p2_4 -> Message.message(applicationContext, "Muy Probable")
                    R.id.sj_p2_5 -> Message.message(applicationContext, "Definitivamente Si")
                }
            }
        })

        rg_sj_3?.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            fun onCheckedChange(checkedId3: Int) {
                findRadioButton3(checkedId3)
            }

            override fun onCheckedChanged(group: RadioGroup?, checkedId3: Int) {
                when (checkedId3){
                    R.id.sj_p3_1 -> Message.message(applicationContext, "Definitivamente No")
                    R.id.sj_p3_2 -> Message.message(applicationContext, "Poco Probable")
                    R.id.sj_p3_3 -> Message.message(applicationContext, "Probable")
                    R.id.sj_p3_4 -> Message.message(applicationContext, "Muy Probable")
                    R.id.sj_p3_5 -> Message.message(applicationContext, "Definitivamente Si")
                }
            }
        })

        rg_sj_4?.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            fun onCheckedChange(checkedId4: Int) {
                findRadioButton4(checkedId4)
            }

            override fun onCheckedChanged(group: RadioGroup?, checkedId4: Int) {
                when (checkedId4){
                    R.id.sj_p4_1 -> Message.message(applicationContext, "Definitivamente No")
                    R.id.sj_p4_2 -> Message.message(applicationContext, "Poco Probable")
                    R.id.sj_p4_3 -> Message.message(applicationContext, "Probable")
                    R.id.sj_p4_4 -> Message.message(applicationContext, "Muy Probable")
                    R.id.sj_p4_5 -> Message.message(applicationContext, "Definitivamente Si")
                }
            }
        })
        rg_sj_5?.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            fun onCheckedChange(checkedId5: Int) {
                findRadioButton5(checkedId5)
            }

            override fun onCheckedChanged(group: RadioGroup?, checkedId5: Int) {
                when (checkedId5){
                    R.id.sj_p5_1 -> Message.message(applicationContext, "Definitivamente No")
                    R.id.sj_p5_2 -> Message.message(applicationContext, "Poco Probable")
                    R.id.sj_p5_3 -> Message.message(applicationContext, "Probable")
                    R.id.sj_p5_4 -> Message.message(applicationContext, "Muy Probable")
                    R.id.sj_p5_5 -> Message.message(applicationContext, "Definitivamente Si")
                }
            }
        })
        rg_sj_6?.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            fun onCheckedChange(checkedId6: Int) {
                findRadioButton6(checkedId6)
            }

            override fun onCheckedChanged(group: RadioGroup?, checkedId6: Int) {
                when (checkedId6){
                    R.id.sj_p6_1 -> Message.message(applicationContext, "Definitivamente No")
                    R.id.sj_p6_2 -> Message.message(applicationContext, "Poco Probable")
                    R.id.sj_p6_3 -> Message.message(applicationContext, "Probable")
                    R.id.sj_p6_4 -> Message.message(applicationContext, "Muy Probable")
                    R.id.sj_p6_5 -> Message.message(applicationContext, "Definitivamente Si")
                }
            }
        })
        rg_sj_7?.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            fun onCheckedChange(checkedId7: Int) {
                findRadioButton7(checkedId7)
            }

            override fun onCheckedChanged(group: RadioGroup?, checkedId7: Int) {
                when (checkedId7){
                    R.id.sj_p7_1 -> Message.message(applicationContext, "Definitivamente No")
                    R.id.sj_p7_2 -> Message.message(applicationContext, "Poco Probable")
                    R.id.sj_p7_3 -> Message.message(applicationContext, "Probable")
                    R.id.sj_p7_4 -> Message.message(applicationContext, "Muy Probable")
                    R.id.sj_p7_5 -> Message.message(applicationContext, "Definitivamente Si")
                }
            }
        })

        //btnGuardar?.setOnClickListener(this)

       /**val button = findViewById<Button>(R.id.btnGuardar)
        button?.setOnClickListener {

        }**/

        /**btnGuardar=findViewById(R.id.btnGuardar);
        btnGuardar?.setOnClickListener {

        }**/




        id_encuesta= findViewById(R.id.id_encuesta)

        

    }

    private fun findRadioButton(checkedId: Int) {
        when (checkedId) {
            R.id.sj_p1_1 -> Message.message(applicationContext, "Definitivamente No")
            R.id.sj_p1_2 -> Message.message(applicationContext, "Poco Probable")
            R.id.sj_p1_3 -> Message.message(applicationContext, "Probable")
            R.id.sj_p1_4 -> Message.message(applicationContext, "Muy Probable")
            R.id.sj_p1_5 -> Message.message(applicationContext, "Definitivamente Si")
        }
    }
    private fun findRadioButton2(checkedId2: Int) {
        when (checkedId2) {
            R.id.sj_p2_1 -> Message.message(applicationContext, "Definitivamente No")
            R.id.sj_p2_2 -> Message.message(applicationContext, "Poco Probable")
            R.id.sj_p2_3 -> Message.message(applicationContext, "Probable")
            R.id.sj_p2_4 -> Message.message(applicationContext, "Muy Probable")
            R.id.sj_p2_5 -> Message.message(applicationContext, "Definitivamente Si")
        }
    }

    private fun findRadioButton3(checkedId3: Int) {
        when (checkedId3) {
            R.id.sj_p3_1 -> Message.message(applicationContext, "Definitivamente No")
            R.id.sj_p3_2 -> Message.message(applicationContext, "Poco Probable")
            R.id.sj_p3_3 -> Message.message(applicationContext, "Probable")
            R.id.sj_p3_4 -> Message.message(applicationContext, "Muy Probable")
            R.id.sj_p3_5 -> Message.message(applicationContext, "Definitivamente Si")
        }
    }
    private fun findRadioButton4(checkedId4: Int) {
        when (checkedId4) {
            R.id.sj_p4_1 -> Message.message(applicationContext, "Definitivamente No")
            R.id.sj_p4_2 -> Message.message(applicationContext, "Poco Probable")
            R.id.sj_p4_3 -> Message.message(applicationContext, "Probable")
            R.id.sj_p4_4 -> Message.message(applicationContext, "Muy Probable")
            R.id.sj_p4_5 -> Message.message(applicationContext, "Definitivamente Si")
        }
    }
    private fun findRadioButton5(checkedId5: Int) {
        when (checkedId5) {
            R.id.sj_p5_1 -> Message.message(applicationContext, "Definitivamente No")
            R.id.sj_p5_2 -> Message.message(applicationContext, "Poco Probable")
            R.id.sj_p5_3 -> Message.message(applicationContext, "Probable")
            R.id.sj_p5_4 -> Message.message(applicationContext, "Muy Probable")
            R.id.sj_p5_5 -> Message.message(applicationContext, "Definitivamente Si")
        }
    }
    private fun findRadioButton6(checkedId6: Int) {
        when (checkedId6) {
            R.id.sj_p6_1 -> Message.message(applicationContext, "Definitivamente No")
            R.id.sj_p6_2 -> Message.message(applicationContext, "Poco Probable")
            R.id.sj_p6_3 -> Message.message(applicationContext, "Probable")
            R.id.sj_p6_4 -> Message.message(applicationContext, "Muy Probable")
            R.id.sj_p6_5 -> Message.message(applicationContext, "Definitivamente Si")
        }
    }
    private fun findRadioButton7(checkedId7: Int) {
        when (checkedId7) {
            R.id.sj_p7_1 -> Message.message(applicationContext, "Definitivamente No")
            R.id.sj_p7_2 -> Message.message(applicationContext, "Poco Probable")
            R.id.sj_p7_3 -> Message.message(applicationContext, "Probable")
            R.id.sj_p7_4 -> Message.message(applicationContext, "Muy Probable")
            R.id.sj_p7_5 -> Message.message(applicationContext, "Definitivamente Si")
        }
    }



    /**override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.btnGuardar -> {
                guardarDatos()
            }
        }
    }

    fun guardarDatos() {
        id_enc = id_encuesta!!.text.toString()
        pre1 = contenedor!!.text.toString()
        pre2 = contenedor1!!.text.toString()
        pre3 = contenedor2!!.text.toString()
        pre4 = contenedor3!!.text.toString()
        pre5 = contenedor4!!.text.toString()
        pre6 = contenedor5!!.text.toString()
        pre7 = contenedor6!!.text.toString()
        /**if (id_enc!!.matches("") || pre1!!.matches("") || pre2!!.matches("") || pre3!!.matches("") || pre4!!.matches(
                ""
            ) || pre5!!.matches("") || pre6!!.matches("") || pre7!!.matches("")
        ) {
            Toast.makeText(this, "Te falta llenar uno o más campos.", Toast.LENGTH_LONG).show()
        } else {**/
        val helper = Helper(this, "Admin", null, 7)
        val sqLiteDatabase: SQLiteDatabase = helper.getWritableDatabase()
        val registro = sqLiteDatabase.rawQuery("SELECT * FROM t_registros WHERE id = $id_enc", null)
        if (registro.moveToFirst()) {
            Toast.makeText(this, "Ya existe ese Id", Toast.LENGTH_SHORT).show()
            sqLiteDatabase.close()
        } else {
            try {
                val valores = ContentValues()
                valores.put("id", id_enc)
                valores.put("pregunta1", pre1)
                valores.put("pregunta2", pre2)
                valores.put("pregunta3", pre3)
                valores.put("pregunta4", pre4)
                valores.put("pregunta5", pre5)
                valores.put("pregunta6", pre6)
                valores.put("pregunta7", pre7)
                sqLiteDatabase.insert("t_registros", null, valores)
                sqLiteDatabase.close()
                Toast.makeText(this, "Se ha cargado el registro", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "Error en el registro $e", Toast.LENGTH_SHORT).show()
            }
        }
    }**/

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

    }

    override fun onClick(v: View?) {

    }
}
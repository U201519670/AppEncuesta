package com.example.myproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.view.View

import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sala_de_juego.*

class SalaDeJuego : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

    var rb_a1:RadioButton? = null
    var rb_a2:RadioButton? = null
    var rb_a3:RadioButton? = null
    var rb_a4:RadioButton? = null
    var rb_a5:RadioButton? = null
    var rg_a1:RadioGroup? = null
    var rb_b1:RadioButton? = null
    var rb_b2:RadioButton? = null
    var rb_b3:RadioButton? = null
    var rb_b4:RadioButton? = null
    var rb_b5:RadioButton? = null
    var rg_b1:RadioGroup? = null
    var rb_c1:RadioButton? = null
    var rb_c2:RadioButton? = null
    var rb_c3:RadioButton? = null
    var rb_c4:RadioButton? = null
    var rb_c5:RadioButton? = null
    var rg_c1:RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sala_de_juego)

        rg_a1 = findViewById(R.id.rg_sj_1)
        rb_a1 = findViewById(R.id.sj_p1_1)
        rb_a2 = findViewById(R.id.sj_p1_2)
        rb_a3 = findViewById(R.id.sj_p1_3)
        rb_a4 = findViewById(R.id.sj_p1_4)
        rb_a5 = findViewById(R.id.sj_p1_5)

        rg_a1?.setOnCheckedChangeListener(this)

        rg_b1 = findViewById(R.id.rg_sj_2)
        rb_b1 = findViewById(R.id.sj_p2_1)
        rb_b2 = findViewById(R.id.sj_p2_2)
        rb_b3 = findViewById(R.id.sj_p2_3)
        rb_b4 = findViewById(R.id.sj_p2_4)
        rb_b5 = findViewById(R.id.sj_p2_5)

        rg_b1?.setOnCheckedChangeListener(this)

        rg_c1 = findViewById(R.id.rg_sj_3)
        rb_c1 = findViewById(R.id.sj_p3_1)
        rb_c2 = findViewById(R.id.sj_p3_2)
        rb_c3 = findViewById(R.id.sj_p3_3)
        rb_c4 = findViewById(R.id.sj_p3_4)
        rb_c5 = findViewById(R.id.sj_p3_5)

        rg_c1?.setOnCheckedChangeListener(this)

    }

    override fun onCheckedChanged(group: RadioGroup?, idRadio: Int) {
        when (idRadio){
            rb_a1?.id -> Toast.makeText(this, "Definitivamente No", Toast.LENGTH_LONG).show()
            rb_a2?.id -> Toast.makeText(this, "Poco Probable", Toast.LENGTH_LONG).show()
            rb_a3?.id -> Toast.makeText(this, "Probable", Toast.LENGTH_LONG).show()
            rb_a4?.id -> Toast.makeText(this, "Muy Probable", Toast.LENGTH_LONG).show()
            rb_a5?.id -> Toast.makeText(this, "Definitivamente Si", Toast.LENGTH_LONG).show()
            rb_b1?.id -> Toast.makeText(this, "Definitivamente No", Toast.LENGTH_LONG).show()
            rb_b2?.id -> Toast.makeText(this, "Poco Probable", Toast.LENGTH_LONG).show()
            rb_b3?.id -> Toast.makeText(this, "Probable", Toast.LENGTH_LONG).show()
            rb_b4?.id -> Toast.makeText(this, "Muy Probable", Toast.LENGTH_LONG).show()
            rb_b5?.id -> Toast.makeText(this, "Definitivamente Si", Toast.LENGTH_LONG).show()
            rb_c1?.id -> Toast.makeText(this, "Definitivamente No", Toast.LENGTH_LONG).show()
            rb_c2?.id -> Toast.makeText(this, "Poco Probable", Toast.LENGTH_LONG).show()
            rb_c3?.id -> Toast.makeText(this, "Probable", Toast.LENGTH_LONG).show()
            rb_c4?.id -> Toast.makeText(this, "Muy Probable", Toast.LENGTH_LONG).show()
            rb_c5?.id -> Toast.makeText(this, "Definitivamente Si", Toast.LENGTH_LONG).show()
        }
    }
}
package com.example.myproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.RadioGroup
import android.widget.TextView
import android.os.Bundle
import android.widget.RadioButton
import android.content.SharedPreferences
import android.view.View
import kotlinx.android.synthetic.main.activity_dash.*
import kotlinx.android.synthetic.main.activity_datos_clientes.*
import android.R.attr.checked


import android.R.attr


class ServiciosActivity : AppCompatActivity() {

    var radioGroup: RadioGroup? = null
    var textCheckedID: TextView? = null
    var textCheckedIndex: TextView? = null
    val KEY_SAVED_RADIO_BUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios)
        radioGroup = findViewById<View>(R.id.radiogroup) as RadioGroup
        radioGroup!!.setOnCheckedChangeListener(radioGroupOnCheckedChangeListener)
        textCheckedID = findViewById<View>(R.id.checkedid) as TextView
        textCheckedIndex = findViewById<View>(R.id.checkedindex) as TextView
        LoadPreferences()

        datos_cliente.setOnClickListener {
            startActivity(Intent(this, DashActivity::class.java))
        }

    }

    var radioGroupOnCheckedChangeListener = RadioGroup.OnCheckedChangeListener { group, checkedId ->
        val checkedRadioButton = radioGroup!!.findViewById<View>(checkedId) as RadioButton
        val checkedIndex = radioGroup!!.indexOfChild(checkedRadioButton)
        textCheckedID!!.text = "checkedID = $checkedId"
        textCheckedIndex!!.text = "checkedIndex = $checkedIndex"
        SavePreferences(KEY_SAVED_RADIO_BUTTON_INDEX, checkedIndex)
    }

    private fun SavePreferences(key: String, value: Int) {
        val sharedPreferences = getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.commit()
        startActivity(Intent(this, DashActivity::class.java))
        val i = Intent(this, DashActivity::class.java)
        i.putExtra("MY_SHARED_PREF", textCheckedIndex!!.text.toString())
        startActivity(i)
    }

    private fun LoadPreferences() {
        val sharedPreferences = getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE)
        val savedRadioIndex = sharedPreferences.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0)
        val savedCheckedRadioButton = radioGroup!!.getChildAt(savedRadioIndex) as RadioButton
        savedCheckedRadioButton.isChecked = true
    }

}




package com.example.MyApplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class ConcatActivity : AppCompatActivity() {
   // private lateinit var binding: ActivityConcatBinding
    lateinit var btnConcat: Button
    lateinit var editTextch1: EditText
    lateinit var editTextch2: EditText
    lateinit var checkBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
     //   binding = ActivityConcatBinding.inflate(layoutInflater)
      //  setContentView(binding.root)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcul )
        btnConcat.setOnClickListener {
            concatenateStrings()
        }
    }  private fun concatenateStrings() {
        val str1 = editTextch1.text.toString()
        val str2 = editTextch2.text.toString()
        val checkBoxChecked = checkBox.isChecked

        val concatenatedString = str1 + str2

        if (checkBoxChecked) {
            val message = "Chaîne concaténée : $concatenatedString\nLongueur : ${concatenatedString.length}"
            showToast(message)
        } else {
            showToast("Chaîne concaténée : $concatenatedString")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun retournerALaPageHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
package com.example.MyApplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MoyenneActivity : AppCompatActivity() {
    private lateinit var editTextNote1: EditText
    private lateinit var editTextNote2: EditText
    private lateinit var editTextNote3: EditText
    private lateinit var btnCalculateAverage: Button
    private lateinit var textViewResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moyenne)
        editTextNote1 = findViewById(R.id.editTextNote1)
        editTextNote2 = findViewById(R.id.editTextNote2)
        editTextNote3 = findViewById(R.id.editTextNote3)
        btnCalculateAverage = findViewById(R.id.btnCalculateAverage)
        textViewResult = findViewById(R.id.textViewResult)

        btnCalculateAverage.setOnClickListener { calculateAverage() }
    }

    private fun calculateAverage() {
        val note1 = editTextNote1.text.toString().toFloat()
        val note2 = editTextNote2.text.toString().toFloat()
        val note3 = editTextNote3.text.toString().toFloat()

        val average = (note1 + note2 + note3) / 3

        val message = "Moyenne : $average"
        textViewResult.text = message

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun retournerALaPageHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
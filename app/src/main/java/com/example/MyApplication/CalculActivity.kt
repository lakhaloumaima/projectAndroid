package com.example.MyApplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculActivity : AppCompatActivity() {
    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var textViewResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcul)
        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        textViewResult = findViewById(R.id.textViewResult)

        btnAdd.setOnClickListener { performOperation('+') }
        btnSubtract.setOnClickListener { performOperation('-') }
        btnMultiply.setOnClickListener { performOperation('*') }
        btnDivide.setOnClickListener { performOperation('/') }
    }

    private fun performOperation(operator: Char) {
        val num1 = editTextNumber1.text.toString().toInt()
        val num2 = editTextNumber2.text.toString().toInt()

        val result = when (operator) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> if (num2 != 0) num1.toDouble() / num2.toDouble() else 0.0
            else -> 0
        }

        textViewResult.text = "Résultat : $result"

    }

    fun retournerALaPageHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
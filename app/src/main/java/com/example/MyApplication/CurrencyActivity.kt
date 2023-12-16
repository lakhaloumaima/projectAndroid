package com.example.MyApplication


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CurrencyActivity : AppCompatActivity() {
    lateinit var amountEditText: EditText
    lateinit var convertToEuroButton: Button
    lateinit var convertToDTButton: Button
    lateinit var resultTextView: TextView
    private val requestCodeConversion = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)
        amountEditText = findViewById(R.id.editTextText)
        convertToEuroButton = findViewById(R.id.button)
        convertToDTButton = findViewById(R.id.button2)
        resultTextView = findViewById(R.id.textView)
        convertToEuroButton.setOnClickListener { convertAndDisplayResult("DT_TO_EURO") }
        convertToDTButton.setOnClickListener { convertAndDisplayResult("EURO_TO_DT") }

    }

    private fun convertAndDisplayResult(conversionType: String) {

        val amountText = amountEditText.text.toString()
        if (amountText.isEmpty()) {
            Toast.makeText(this, R.string.Donner, Toast.LENGTH_SHORT).show()
            return
        }
        val amount = amountText.toFloat()
        val conversionResult = when (conversionType) {
            "DT_TO_EURO" -> amount / 3.2
            "EURO_TO_DT" -> amount * 3.2
            else -> 0.0
        }

        val conversionTypeResId = if (conversionType == "DT_TO_EURO") R.string.btn1 else R.string.btn2



        val intent = Intent(this, ConversionActivity::class.java)

        intent.putExtra("AMOUNT", amount)
        intent.putExtra("CONVERSION_TYPE", conversionType)
        startActivityForResult(intent, requestCodeConversion)


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == requestCodeConversion) {
            if (resultCode == Activity.RESULT_OK) {
                val conversionResult = data?.getDoubleExtra("CONVERSION_RESULT", 0.0)

                val resultMessage = "Résultat : $conversionResult"
                resultTextView.text = resultMessage
            } else {
                Toast.makeText(this, "Aucun résultat reçu", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun naviguerVersAccueil(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}



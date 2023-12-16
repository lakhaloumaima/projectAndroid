package com.example.MyApplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ConversionActivity : AppCompatActivity() {
    lateinit var resultTextView: TextView
    lateinit var btnEnvoyerResultat: Button
    lateinit var btnTerminer: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)
        resultTextView = findViewById(R.id.resultTextView)
        btnEnvoyerResultat = findViewById(R.id.btnEnvoyerResultat)
        btnTerminer = findViewById(R.id.btnTerminer)
        btnEnvoyerResultat.setOnClickListener {
            envoyerResultat()
        }

        btnTerminer.setOnClickListener {
            terminerSansResultat()
        }
    }

    fun envoyerResultat() {
        val amount = intent.getFloatExtra("AMOUNT", 0f)
        val conversionType = intent.getStringExtra("CONVERSION_TYPE")

        val conversionResult = when (conversionType) {
            "DT_TO_EURO" -> amount / 3.2
            "EURO_TO_DT" -> amount * 3.2
            else -> 0.0
        }

        val intent = Intent()
        intent.putExtra("CONVERSION_RESULT", conversionResult)
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun terminerSansResultat() {
        Toast.makeText(this, "Aucun résultat envoyé", Toast.LENGTH_SHORT).show()

        setResult(RESULT_CANCELED)
        finish()
    }
}
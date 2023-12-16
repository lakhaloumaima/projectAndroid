package com.example.MyApplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class TemperatureActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var editTextTemperature: EditText
    private lateinit var checkBoxRoundResult: CheckBox
    private lateinit var buttonConvert: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        radioGroup = findViewById(R.id.radioGroup)
        editTextTemperature = findViewById(R.id.editTextTemperature)
        checkBoxRoundResult = findViewById(R.id.checkBoxRoundResult)
        buttonConvert = findViewById(R.id.buttonConvert)
        textViewResult = findViewById(R.id.textViewResult)

        buttonConvert.setOnClickListener { convertTemperature() }
    }

    private fun convertTemperature() {

        val temperatureText = editTextTemperature.text.toString()

        if (temperatureText.isEmpty()) {
            Toast.makeText(this, R.string.warning_empty_input, Toast.LENGTH_SHORT).show()
            return
        }

        val temperature = temperatureText.toFloat()
        val isCelsiusToFahrenheit = radioGroup.checkedRadioButtonId == R.id.radioCelsiusToFahrenheit
        val isRoundResult = checkBoxRoundResult.isChecked

        val convertedTemperature = if (isCelsiusToFahrenheit) {
            celsiusToFahrenheit(temperature)
        } else {
            fahrenheitToCelsius(temperature)
        }

        if (isRoundResult) {
            convertedTemperature.let {
                textViewResult.text = String.format("%.2f", it)
            }
        } else {
            textViewResult.text = convertedTemperature.toString()
        }
    }

    private fun fahrenheitToCelsius(fahrenheit: Float): Float {
        return (fahrenheit - 32) * 5/9
    }

    private fun celsiusToFahrenheit(celsius: Float): Float {
        return (celsius * 9/5) + 32
    }
    fun naviguerVersAccueil(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

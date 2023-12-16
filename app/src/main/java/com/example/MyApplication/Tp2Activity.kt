package com.example.MyApplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Tp2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tp2)
    }
    fun navigateToCurrencyConversion(view: View) {
        val intent = Intent(this, CurrencyActivity::class.java)
        startActivity(intent)
    }

    fun navigateToTemperatureConversion(view: View) {
        val intent = Intent(this, TemperatureActivity::class.java)
        startActivity(intent)
    }

}
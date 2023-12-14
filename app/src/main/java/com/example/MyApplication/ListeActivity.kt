package com.example.MyApplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class ListeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste )

        val cities = arrayOf("Tunis", "Sousse", "Monastir", "Sfax", "Djerba")

        val listViewCities: ListView = findViewById(R.id.listViewCities)
        val textViewSelectedCity: TextView = findViewById(R.id.textViewSelectedCity)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)
        listViewCities.adapter = adapter

        listViewCities.setOnItemClickListener { _, _, position, _ ->
            val selectedCity = cities[position]
            textViewSelectedCity.text = "Selected City: $selectedCity"

            // Launch Google search for the selected city
            val searchUrl = "http://www.google.fr/search?q=$selectedCity"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl))
            startActivity(intent)
        }
    }

}
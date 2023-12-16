package com.example.MyApplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.MyApplication.databinding.ActivityWorldBinding

class WorldActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWorldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorldBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner1 = findViewById<Spinner>( R.id.spinner1 )
        val spinner2 = findViewById<Spinner>( R.id.spinner2 )

        // aquisation des valeurs
        val continents = resources.getStringArray(R.array.Continents)
        val PaysAfr = resources.getStringArray(R.array.PaysAfr)
        val PaysEur = resources.getStringArray(R.array.PaysEur)
        val PaysAsie = resources.getStringArray(R.array.PaysAsie)
        val PaysOc = resources.getStringArray(R.array.PaysOc)
        val PaysAm = resources.getStringArray(R.array.PaysAm)

        // creation adaptateur from spinner 1
        val adapterForSpinnerOne = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, continents
        )
        spinner1.adapter = adapterForSpinnerOne

        val adapterPaysAfr =  ArrayAdapter(
            this, android.R.layout.simple_spinner_item, PaysAfr
        )
        val adapterPaysEur =  ArrayAdapter(
            this, android.R.layout.simple_spinner_item, PaysEur
        )
        val adapterPaysAsie =  ArrayAdapter(
            this, android.R.layout.simple_spinner_item, PaysAsie
        )
        val adapterPaysOc =  ArrayAdapter(
            this, android.R.layout.simple_spinner_item, PaysOc
        )
        val adapterPaysAm =  ArrayAdapter(
            this, android.R.layout.simple_spinner_item, PaysAm
        )

        var selectedItem1 = ""
        var selectedItem2 = ""
        var selectedList = arrayOf<String>()

        // Sélection d'un continent
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedContinent = continents[position]
                when ( continents[position] ) {
                    "Afrique" -> {
                        spinner2.adapter = adapterPaysAfr; selectedList = PaysAfr
                    }
                    "Europe" -> {
                        spinner2.adapter = adapterPaysEur; selectedList = PaysEur
                    }
                    "Asie" -> {
                        spinner2.adapter = adapterPaysAsie; selectedList = PaysAsie
                    }
                    "Océanie" -> {
                        spinner2.adapter = adapterPaysOc; selectedList = PaysOc
                    }
                    "Amérique" -> {
                        spinner2.adapter = adapterPaysAm; selectedList = PaysAm
                    }
                    else -> ""

                }
                binding.textViewResult.text = selectedList.joinToString(", ") // Join array elements

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Ne rien faire ici
            }
        }


    }


}
package com.example.MyApplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.example.MyApplication.databinding.ActivityTp5Binding

class Tp5Activity : AppCompatActivity() {
    lateinit var binding: ActivityTp5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Remove the 'val' keyword to use the class-level binding property
        binding = ActivityTp5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioConcat -> showToastAndStartActivity(ConcatActivity::class.java)
                R.id.radioCalcul -> showToastAndStartActivity(CalculActivity::class.java)
                R.id.radioMoy -> showToastAndStartActivity(MoyenneActivity::class.java)
                else -> throw IllegalArgumentException("Sélection de bouton radio invalide")
            }
        }

        Toast.makeText(this, R.string.choose_activity_prompt, Toast.LENGTH_SHORT).show()
    }

    private fun showToastAndStartActivity(activityClass: Class<*>) {
        Toast.makeText(this, "Bouton radio sélectionné", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@Tp5Activity, activityClass)
        startActivity(intent)
    }
}

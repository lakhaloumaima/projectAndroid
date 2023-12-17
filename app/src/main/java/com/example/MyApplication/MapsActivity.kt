package com.example.MyApplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MapsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val maps: TextView = findViewById(R.id.maps)

        maps.setOnClickListener {
            // Open map with the current location
            val mapIntentUri: Uri = Uri.parse("geo:0,0?q=my+location")
            val mapIntent = Intent(Intent.ACTION_VIEW, mapIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")

            // Check if there's an activity to handle the map intent
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                // Handle the case where there is no app to handle the map intent
                Toast.makeText(this, "No app to handle map intent", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

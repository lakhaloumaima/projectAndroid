package com.example.MyApplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    lateinit var tp1:Button
    lateinit var tp2:Button
    lateinit var tp3:Button
    lateinit var tp4p1:Button
    lateinit var tp4p2:Button
    lateinit var tp5:Button
    lateinit var tp6:Button
    lateinit var tp7:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tp1 =findViewById(R.id.tp1 )
        tp2 =findViewById(R.id.tp2 )
        tp3 =findViewById(R.id.tp3 )
        tp4p1 =findViewById(R.id.tp4p1 )
        tp4p2 =findViewById(R.id.tp4p2 )
        tp5 =findViewById(R.id.tp5 )
        tp6 =findViewById(R.id.tp6 )
        tp7 =findViewById(R.id.tp7 )

        val download: Button = findViewById(R.id.download)
        download.setOnClickListener {
            intent = Intent(this,DownloadActivity::class.java)
            startActivity(intent)
        }

        tp1.setOnClickListener {
            intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        tp2.setOnClickListener {
            intent = Intent(this,Tp2Activity::class.java)
            startActivity(intent)
        }
        tp3.setOnClickListener {
            intent = Intent(this,AppActivity::class.java)
            startActivity(intent)
        }

        tp4p1.setOnClickListener {
            intent = Intent(this,ListeActivity::class.java)
            startActivity(intent)

        }
        tp4p2.setOnClickListener {
            intent = Intent(this,WorldActivity::class.java)
            startActivity(intent)

        }

        tp5.setOnClickListener {
            intent = Intent(this,Tp5Activity::class.java)
            startActivity(intent)
        }
        tp6.setOnClickListener {
            intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        tp7.setOnClickListener {
            intent = Intent(this,MapsActivity::class.java)
            startActivity(intent)
        }


    }


}

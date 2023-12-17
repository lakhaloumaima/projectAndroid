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
    lateinit var mAuth: FirebaseAuth
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var btn:Button
    lateinit var btnLogin:Button
    lateinit var maps:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth=FirebaseAuth.getInstance()
        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        btn=findViewById(R.id.btnRegister )
        btnLogin=findViewById(R.id.loginRedirectText )
        val imageView: TextView = findViewById(R.id.maps)

        val download: Button = findViewById(R.id.download)
        download.setOnClickListener {
         //   intent = Intent(this,DownloadActivity::class.java)
           // startActivity(intent)
        }

        btn.setOnClickListener {
            createUser()
        }
        btnLogin.setOnClickListener {
            intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        imageView.setOnClickListener {
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

    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = mAuth.currentUser
        if(currentUser!==null){
            Toast.makeText(this,"user already connected",Toast.LENGTH_LONG).show()

         //   finish()
        }
    }
    fun createUser () {
        mAuth.createUserWithEmailAndPassword(email.text.toString(),password.text.toString())
            .addOnCompleteListener { task->
            if (task.isSuccessful){
               // val currentUser :FirebaseUser? = mAuth.currentUser
                Toast.makeText(this,"user created",Toast.LENGTH_LONG).show()
               // intent = Intent(this,LoginActivity::class.java)
              //  startActivity(intent)
            }else{
                Toast.makeText(this,"user not created !!",Toast.LENGTH_LONG).show()
            }

        }
    }
}

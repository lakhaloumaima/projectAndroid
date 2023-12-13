package com.example.MyApplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var btn:Button
    lateinit var btnLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth=FirebaseAuth.getInstance()
        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        btn=findViewById(R.id.create)
        btnLogin=findViewById(R.id.login)
        btn.setOnClickListener {
            createUser()
        }
        btnLogin.setOnClickListener {
            intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
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

package com.example.MyApplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth;
    lateinit var email: EditText;
    lateinit var password: EditText
    lateinit var btn: Button;
    lateinit var signupRedirectText: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth=FirebaseAuth.getInstance();
        email=findViewById(R.id.email);
        password=findViewById(R.id.password)
        signupRedirectText = findViewById(R.id.signupRedirectText)
        btn=findViewById(R.id.login)

        signupRedirectText.setOnClickListener {
            intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        btn.setOnClickListener { login() }
    }
    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = mAuth.currentUser
        if(currentUser!==null){
            Toast.makeText(this,"user already connected", Toast.LENGTH_LONG).show()
          //  val intent = Intent(this, ProfilActivity::class.java)
       //     startActivity(intent)
           // finish()
        }
    }
    fun login () {
        mAuth.signInWithEmailAndPassword(email.text.toString(),password.text.toString())
            .addOnCompleteListener { task->
            if (task.isSuccessful){
                val currentUser: FirebaseUser? = mAuth.currentUser
                Toast.makeText(this,"Autth success",Toast.LENGTH_LONG).show()
                intent = Intent(this,ProfilActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Autth failed",Toast.LENGTH_LONG).show()
            }

        }
    }
}
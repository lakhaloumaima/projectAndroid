package com.example.MyApplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var btnRegister: Button
    lateinit var loginNow: TextView
    lateinit var email: EditText;
    lateinit var password: EditText;

    public override fun onStart() {
        super.onStart()
// Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnRegister = findViewById(R.id.btnRegister)
        loginNow = findViewById(R.id.loginRedirectText)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

        auth = FirebaseAuth.getInstance()
        loginNow.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnRegister.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()
           // binding.progress.visibility = View.VISIBLE
            if (email.isEmpty()) {
                Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show()
              //  binding.progress.visibility = View.GONE
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show()
             //   binding.progress.visibility = View.GONE
                return@setOnClickListener
            }
            /*      val passwordRegex = Regex("^(?=.*[A-Z])(?=.*\\d).{6,}\$")
                  if (!password.matches(passwordRegex)) {
                      Toast.makeText(this, "Password must be at least 6 characters long, contain at least one uppercase letter, and one digit.", Toast.LENGTH_SHORT).show()
                      binding.progress.visibility = View.GONE
                      return@setOnClickListener
                  }*/
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
               //     binding.progress.visibility = View.GONE
                    if (task.isSuccessful) {
// Sign in success, update UI with the signed-in user's
                        Toast.makeText(
                            baseContext,
                            "Account created.",
                            Toast.LENGTH_SHORT,

                            ).show()

                        val intent = Intent(this, MainActivity::class.java)

                        startActivity(intent)

                        finish()
                    } else {
// If sign-in fails, display a message to the user.
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.....",
                            Toast.LENGTH_SHORT,

                            ).show()
                    }
                }
        }
    }
}
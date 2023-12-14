package com.example.MyApplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

class ProfilActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var email: TextView
    private lateinit var id: TextView
    private lateinit var btn: Button
    private lateinit var name: EditText
    private lateinit var liste: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        mAuth = FirebaseAuth.getInstance()
        name = findViewById(R.id.name)
        liste = findViewById(R.id.liste)
        id = findViewById(R.id.id)
        email = findViewById(R.id.email)
        btn = findViewById(R.id.update)
        btn.setOnClickListener { updateProfile() }

        liste.setOnClickListener {
             intent = Intent(this,ListeActivity::class.java)
             startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = mAuth.currentUser
        if (currentUser != null) {
            val user: FirebaseUser? = mAuth.currentUser
            id.text = user?.uid
            email.text = user?.email
            name.setText(user?.displayName)
        }
    }

    private fun updateProfile() {
        val user = mAuth.currentUser
        val newName = name.text.toString()

        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName(newName)
            .build()

        user?.updateProfile(profileUpdates)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Profile updated successfully
                    val updatedUser = mAuth.currentUser
                    name.setText(updatedUser?.displayName) // Update the EditText with the new name
                    val intent = Intent(this, AppActivity::class.java)
                    startActivity(intent)
                    // You can show a toast or perform other actions if needed
                } else {
                    // Handle the failure to update the profile
                    // You can show an error message or perform other actions
                }
            }
    }
}

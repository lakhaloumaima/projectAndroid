package com.example.MyApplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
    private lateinit var world: Button
    private lateinit var tp5: Button
    private lateinit var tp2: Button
    private lateinit var tp3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        mAuth = FirebaseAuth.getInstance()
        name = findViewById(R.id.name)
        liste = findViewById(R.id.liste)
        world = findViewById(R.id.world)
        id = findViewById(R.id.id)
        email = findViewById(R.id.email)
        btn = findViewById(R.id.update)
        tp5 = findViewById(R.id.tp5)
        tp2 = findViewById(R.id.tp2)
        tp3 = findViewById(R.id.tp3)

        btn.setOnClickListener { updateProfile() }

        liste.setOnClickListener {
             intent = Intent(this,ListeActivity::class.java)
             startActivity(intent)
        }

        world.setOnClickListener {
            intent = Intent(this,WorldActivity::class.java)
            startActivity(intent)
        }

        tp5.setOnClickListener {
            intent = Intent(this,Tp5Activity::class.java)
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
                    Toast.makeText(this, " Name updated successfully ! ", Toast.LENGTH_SHORT).show()
                 //   val intent = Intent(this, AppActivity::class.java)
                 //   startActivity(intent)
                    // You can show a toast or perform other actions if needed
                } else {
                    // Handle the failure to update the profile
                    // You can show an error message or perform other actions
                    Toast.makeText(this, " Name not updated ! ", Toast.LENGTH_SHORT).show()
                }
            }
    }
}

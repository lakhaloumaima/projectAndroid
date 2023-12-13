package com.example.MyApplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest


class ProfilActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth;
    lateinit var email: TextView;
    lateinit var id: TextView
    lateinit var btn: Button;
    lateinit var name:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil )
        mAuth=FirebaseAuth.getInstance();
        name=findViewById(R.id.name)
        id=findViewById(R.id.id)
        email=findViewById(R.id.email)
        btn=findViewById(R.id.update)
        btn.setOnClickListener { updateProfile() }

    }
    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = mAuth.currentUser
        if(currentUser!== null){
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
                    name.setText(newName)  // Update the EditText with the new name
                    // You can show a toast or perform other actions if needed
                } else {
                    // Handle the failure to update the profile
                    // You can show an error message or perform other actions
                }
            }
    }

}
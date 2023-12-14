package com.example.MyApplication

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.telephony.SmsManager
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.MyApplication.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ActivityAppBinding

    lateinit var imageView: ImageView // Move the declaration here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize imageView after setContentView
        imageView = findViewById(R.id.imageView)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_app)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_app)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu ): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu )
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sms_normal -> {
                // Code à exécuter pour l'option "SMS Normal"
                showToast("SMS Normal selected")
                return true
            }
            R.id.action_sms_urgence -> {
                // Code à exécuter pour l'option "SMS d'Urgence"
                showToast("SMS d'Urgence selected")
                val smsManager = SmsManager.getDefault()
                val phoneNumber = resources.getString(R.string.phone)
                val message = resources.getString(R.string.message)
                smsManager.sendTextMessage(phoneNumber, null, message, null, null)

                return true
            }
            R.id.action_appel_normal -> {
                // Code à exécuter pour l'option "Appel Normal"
                showToast("Appel Normal selected")

                return true
            }
            R.id.action_appel_urgence -> {
                // Code à exécuter pour l'option "Appel d'Urgence"
                showToast("Appel d'Urgence selected")
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:" + resources.getString(R.string.phone))
                startActivity(callIntent)
                return true
            }
            R.id.action_camera -> {
                // Code à exécuter pour l'option "Caméra"
                showToast("Caméra selected")
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                val CAMERA_REQUEST_CODE = 100
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)

                return true
            }
            R.id.action_quitter -> {
                // Code à exécuter pour l'option "Quitter"
                showToast("Quitter selected")
                finish() // Fermer l'application
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val CAMERA_REQUEST_CODE = 100
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            // Handle the captured image, if needed
            val imageBitmap = data?.extras?.get("data") as Bitmap?
            if (imageBitmap != null) {
                // Do something with the imageBitmap
                showToast("Image captured successfully")
              //  imageView.setImageBitmap(imageBitmap)
            }
        }
    }


}
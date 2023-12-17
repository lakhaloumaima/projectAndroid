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
import com.google.android.material.appbar.MaterialToolbar

class AppActivity : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ActivityAppBinding

    lateinit var imageView: ImageView // Move the declaration here
    companion object {
        private const val CAMERA_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: MaterialToolbar  = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        imageView = findViewById(R.id.imageView) // Replace with your actual ImageView ID

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    private fun showToast(messageResId: Int) {
        Toast.makeText(this, getString(messageResId), Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_appel_normal -> {
                showToast("SMS Normal selected")
                // Handle "Appel Normal" click
                // Launch CallActivity or perform the desired action
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:" + resources.getString(R.string.phone))
                startActivity(callIntent)
                return true
            }
            R.id.action_appel_urgence -> {
                showToast("SMS d'Urgence selected")
                // Handle "Appel d’Urgence" click
                // Perform emergency call logic
                return true
            }
            R.id.action_sms_normal -> {
                showToast("Appel Normal selected")
                // Handle "SMS Normal" click
                // Launch WriteSMS activity or perform the desired action
                val phoneNumber = "24540686"
                val message = "Hello, this is a test message."
                // Create an intent with the SMS URI scheme
                val smsIntent = Intent(Intent.ACTION_SENDTO)
                smsIntent.data = Uri.parse("smsto:$phoneNumber")
                // Add the message to the intent
                smsIntent.putExtra("sms_body", message)
                // Start the activity
                startActivity(smsIntent)
                return true
            }
            R.id.action_sms_urgence -> {
                showToast("Appel d'Urgence selected")
                // Handle "SMS d’Urgence" click
                // Perform emergency SMS logic
                return true
            }
            R.id.action_camera -> {
                showToast("Caméra selected")
                // Handle "Caméra" click
                // Launch CameraActivity or perform the desired action
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                val CAMERA_REQUEST_CODE = 100
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
                return true
            }
            R.id.action_quitter -> {
                showToast("Quitter selected")
                // Handle "Quitter" click
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
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            // Handle the captured image
            val imageBitmap = data?.extras?.get("data") as Bitmap?
            if (imageBitmap != null) {
                // Display the captured image in the ImageView
                imageView.setImageBitmap(imageBitmap)

                // Save the image to the device's gallery (optional)
                MediaStore.Images.Media.insertImage(
                    contentResolver,
                    imageBitmap,
                    "Captured Image",
                    "Image captured using the camera"
                )

                showToast("Image captured successfully")
            }
        }
    }


}
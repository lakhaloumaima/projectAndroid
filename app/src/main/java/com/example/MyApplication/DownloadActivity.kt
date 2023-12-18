
package com.example.MyApplication


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DownloadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)
        val item = ArrayList<Notes>()
        item.add(
            Notes(
                R.drawable.baseline_sim_card_download_24,
                "Tp 2",
                "https://riptutorial.com/Download/kotlin-fr.pdf"
            )
        )
        item.add(
            Notes(
                R.drawable.baseline_sim_card_download_24,
                "Tp 3",
                "https://riptutorial.com/Download/kotlin-fr.pdf"
            )
        )
        item.add(
            Notes(
                R.drawable.baseline_sim_card_download_24,
                "Tp 4",
                "https://riptutorial.com/Download/kotlin-fr.pdf"
            )
        )
        item.add(
            Notes(
                R.drawable.baseline_sim_card_download_24,
                "Tp 5",
                "https://riptutorial.com/Download/kotlin-fr.pdf"
            )
        )
        item.add(
            Notes(
                R.drawable.baseline_sim_card_download_24,
                "Tp 6",
                "https://riptutorial.com/Download/kotlin-fr.pdf"
            )
        )
        item.add(
            Notes(
                R.drawable.baseline_sim_card_download_24,
                "Tp 7",
                "https://riptutorial.com/Download/kotlin-fr.pdf"
            )
        )

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = NotesAdapter(item, this)
        recycler_view.adapter = adapter
    }

}
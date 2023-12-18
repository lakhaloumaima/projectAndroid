
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
                "https://drive.google.com/file/d/1BmFje9Q_OS5gTi3xeysrGubCU_lBOseA/view?usp=sharing"
            )
        )
        item.add(
            Notes(
                R.drawable.baseline_sim_card_download_24,
                "Tp 3",
                "https://drive.google.com/file/d/1UZrnYCbOw9BbWeY5E3CfgBGiJ-4g-PWp/view?usp=sharing"
            )
        )
        item.add(
            Notes(
                R.drawable.baseline_sim_card_download_24,
                "Tp 4",
                "https://drive.google.com/file/d/16McFflgygQ37-GAz80dh5k1fOH6vrvfa/view?usp=sharing"
            )
        )
        item.add(
            Notes(
                R.drawable.baseline_sim_card_download_24,
                "Tp 5",
                "https://drive.google.com/file/d/10BSDZfnW9icoNUd_0VbC8r23HhIJQGN5/view?usp=sharing"
            )
        )
        item.add(
            Notes(
                R.drawable.baseline_sim_card_download_24,
                "Tp 6",
                "https://drive.google.com/file/d/1ePbCusXTm0Hmx6nRLV3SoJPSz7laRA-5/view?usp=sharing"
            )
        )
        item.add(
            Notes(
                R.drawable.baseline_sim_card_download_24,
                "Tp 7",
                "https://drive.google.com/file/d/1C3HdXAL9XfzSJGfdx7HmnPJMmt-KrzjR/view?usp=sharing"
            )
        )

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = NotesAdapter(item, this)
        recycler_view.adapter = adapter
    }

}
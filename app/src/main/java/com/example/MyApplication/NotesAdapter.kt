package com.example.MyApplication

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import android.webkit.URLUtil

class NotesAdapter( var data: ArrayList<Notes>, var context: Context) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = data[position].subj_name
        holder.image.setImageResource(data[position].image)
        holder.itemView.setOnClickListener{
            var download= context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            var PdfUri = Uri.parse(data[position].url)
            var getPdf = DownloadManager.Request(PdfUri)
            getPdf.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            download.enqueue(getPdf)
            Toast.makeText(context,"Download Started", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val name: TextView
        internal val image: ImageView
        init {
            name = itemView.findViewById(R.id.subj_name)
            image = itemView.findViewById(R.id.pdf_image)
        }
    }
}

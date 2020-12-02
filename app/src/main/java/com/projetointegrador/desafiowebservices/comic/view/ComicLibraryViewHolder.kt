package com.projetointegrador.desafiowebservices.comic.view

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projetointegrador.desafiowebservices.R
import com.projetointegrador.desafiowebservices.comic.model.ComicModel
import com.squareup.picasso.Picasso

class ComicLibraryViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val number = view.findViewById<TextView>(R.id.txtComicNumber)
    private val image = view.findViewById<ImageView>(R.id.comicImage)

    @SuppressLint("SetTextI18n")
    fun bind(comicModel: ComicModel) {
        number.text = "# ${comicModel.id}"
        val imagePath = comicModel.thumbnail?.getImagePath()
        Picasso.get().load(imagePath).into(image)
    }
}
package com.projetointegrador.desafiowebservices.comic.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projetointegrador.desafiowebservices.R
import com.projetointegrador.desafiowebservices.comic.model.ComicModel

class ComicLibraryAdapter(private val dataset: List<ComicModel>, private val listener: (ComicModel) -> Unit):
    RecyclerView.Adapter<ComicLibraryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicLibraryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comic_library, parent, false)
        return ComicLibraryViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicLibraryViewHolder, position: Int) {
        var item = dataset[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount() = dataset.size


}
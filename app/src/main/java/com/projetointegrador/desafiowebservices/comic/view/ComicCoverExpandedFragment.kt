package com.projetointegrador.desafiowebservices.comic.view

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.projetointegrador.desafiowebservices.R
import com.squareup.picasso.Picasso

class ComicCoverExpandedFragment : DialogFragment() {

    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _view = inflater.inflate(R.layout.fragment_comic_cover_expanded, container, false)

        val image = _view.findViewById<ImageView>(R.id.imgCoverFullscreen)
        val coverThumbnail = arguments?.getString(ComicFragment.COMIC_IMAGE)
        Picasso.get().load(coverThumbnail).into(image)
        onCloseDialog(_view)

        return _view
    }

    private fun onCloseDialog(view: View) {
        view.findViewById<ImageView>(R.id.icCloseDialog).setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog =  super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }
}
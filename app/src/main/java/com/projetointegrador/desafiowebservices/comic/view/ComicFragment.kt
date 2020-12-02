package com.projetointegrador.desafiowebservices.comic.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.projetointegrador.desafiowebservices.R
import com.projetointegrador.desafiowebservices.comic.model.ComicDate
import com.projetointegrador.desafiowebservices.comic.model.ComicPrice
import com.projetointegrador.desafiowebservices.comic.repository.ComicRepository
import com.projetointegrador.desafiowebservices.comic.viewmodel.ComicLibraryViewModel
import com.projetointegrador.desafiowebservices.data.model.ThumbModel
import com.squareup.picasso.Picasso
import java.util.*

class ComicFragment : Fragment() {
    private lateinit var _view: View
    private lateinit var _viewModel: ComicLibraryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comic, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _view = view
        _viewModel = ViewModelProvider(
            this,
            ComicLibraryViewModel.ComicLibraryViewModelFactory(ComicRepository())
        ).get(ComicLibraryViewModel::class.java)

        showLoading(true)
        val comicDescription = arguments?.getString(ComicLibraryFragment.COMICS_DESCRIPTION)
        val comicTitle = arguments?.getString(ComicLibraryFragment.COMICS_TITLE)
        val comicDates = arguments?.get(ComicLibraryFragment.COMICS_DATES)
        val comicPrices = arguments?.get(ComicLibraryFragment.COMICS_PRICE)
        val comicPages = arguments?.getInt(ComicLibraryFragment.COMICS_PAGES)
        val comicImages = arguments?.get(ComicLibraryFragment.COMICS_IMAGES)
        val comicThumbnail = arguments?.getString(ComicLibraryFragment.COMICS_THUMBNAIL)

        val ivComicBackdrop = _view.findViewById<ImageView>(R.id.ivBackdrop)
        val ivComicCover = _view.findViewById<ImageView>(R.id.ivComicCover)
        val tvComicTitle = _view.findViewById<TextView>(R.id.tvComicTitle)
        val tvComicDescription = _view.findViewById<TextView>(R.id.tvComicDescription)
        val tvPublishDate = _view.findViewById<TextView>(R.id.tvPublished)
        val tvPrice = _view.findViewById<TextView>(R.id.tvPrice)
        val tvPages = _view.findViewById<TextView>(R.id.tvPages)

        showLoading(true)
        tvComicTitle.text = comicTitle
        if (comicDescription != null) {
            tvComicDescription.text = comicDescription
        }
        if (comicDates != null) {
            for (date in comicDates as List<ComicDate>) {
                if (date.type?.contains("onsaleDate") == true){
                    var calendar = Calendar.getInstance()
                    calendar.time = date.date!!
                    tvPublishDate.text = "${calendar.getDisplayName(
                        Calendar.MONTH,
                        Calendar.LONG,
                        Locale.getDefault()
                    )} ${calendar.get(Calendar.DAY_OF_MONTH)}, ${calendar.get(Calendar.YEAR)}"
                }
            }
        }
        if (comicPrices != null) {
            tvPrice.text = "$ ${(comicPrices as List<ComicPrice>)[0].price.toString()}"
        }
        tvPages.text = comicPages?.toString()

        Picasso.get().load(comicThumbnail).into(ivComicCover)

        if (comicImages != null) {
            Picasso.get().load(
                (comicImages as List<ThumbModel>)[(comicImages as List<ThumbModel>).size - 1].getImagePath(
                    "landscape_incredible"
                )
            ).into(ivComicBackdrop)
        }
        showLoading(false)
        setBackNavigation()

        ivComicCover.setOnClickListener {
            val navController = findNavController()
            val bundle = bundleOf(COMIC_IMAGE to comicThumbnail)
            navController.navigate(R.id.action_comicFragment_to_comicCoverExpandedFragment, bundle)
        }
    }

    private fun setBackNavigation() {
        _view.findViewById<ImageView>(R.id.ivReturn).setOnClickListener {
            val navController = findNavController()
            navController.navigateUp()
        }
    }

    private fun showLoading(isLoading: Boolean) {
        val viewLoading = _view.findViewById<View>(R.id.comicLoading)

        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

    companion object {
        const val COMIC_IMAGE = "COMIC_IMAGE"
    }
}
package com.projetointegrador.desafiowebservices.comic.model

import com.projetointegrador.desafiowebservices.data.model.ThumbModel

data class ComicModel(
    val id: Int?,
    val title: String?,
    val description: String?,
    val pageCount: Int?,
    val dates: List<ComicDate>?,
    val prices: List<ComicPrice>?,
    val thumbnail: ThumbModel?,
    val images: List<ThumbModel>?
)
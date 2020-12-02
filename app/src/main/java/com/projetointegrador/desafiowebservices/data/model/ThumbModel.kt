package com.projetointegrador.desafiowebservices.data.model

data class ThumbModel (
    private val path: String,
    private val extension: String
) {
    fun getImagePath(imageResolution: String? = "detail"): String {
        return "$path/$imageResolution.$extension".replace("http://", "https://")
    }
}
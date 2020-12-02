package com.projetointegrador.desafiowebservices.comic.repository

import com.projetointegrador.desafiowebservices.comic.model.ComicModel
import com.projetointegrador.desafiowebservices.data.api.NetworkUtils
import com.projetointegrador.desafiowebservices.data.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface IComicEndpoint {
    @GET("/v1/public/comics")
    suspend fun getComics(@Query("offset") offset: Int? = 0, @Query("orderBy") orderBy: String = "title"): ResponseModel<ComicModel>

    companion object {
        val endpoint: IComicEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(IComicEndpoint::class.java)
        }
    }
}
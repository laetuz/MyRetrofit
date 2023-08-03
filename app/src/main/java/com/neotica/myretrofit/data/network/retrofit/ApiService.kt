package com.neotica.myretrofit.data.network.retrofit

import com.neotica.myretrofit.data.network.response.MainResponse
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): MainResponse
}
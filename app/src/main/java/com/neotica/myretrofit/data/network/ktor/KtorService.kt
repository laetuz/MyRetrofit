package com.neotica.myretrofit.data.network.ktor

import com.neotica.myretrofit.data.network.ktor.KtorClient.BASE_URL
import com.neotica.myretrofit.data.network.response.MainResponse
import io.ktor.client.request.get

object KtorService {
    suspend fun getCharacters(): MainResponse {
        return KtorClient.httpClient.use {
            it.get("$BASE_URL/character")
        }
    }
}
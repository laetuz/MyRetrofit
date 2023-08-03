package com.neotica.myretrofit.data.network.response

data class MainResponse (
    val info: InfoResponse,
    val results: List<CharacterResponse>
)

data class InfoResponse(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class CharacterResponse(
    val id: Int,
    val name: String,
    val species: String,
    val gender: String,
    val image: String,
)
package com.neotica.myretrofit.data.network.response

import kotlinx.serialization.Serializable

@Serializable
data class MainResponse (
    val info: InfoResponse,
    val results: List<CharacterResponse>
)

@Serializable
data class InfoResponse(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

@Serializable
data class CharacterResponse(
    val id: Int,
    val name: String,
    val species: String,
    val gender: String,
    val image: String,
)
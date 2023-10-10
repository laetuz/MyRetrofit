package com.neotica.myretrofit.data.local

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neotica.myretrofit.data.network.ktor.KtorService
import com.neotica.myretrofit.data.network.response.CharacterResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _characters = MutableStateFlow<List<CharacterResponse>>(emptyList())
    val characters: StateFlow<List<CharacterResponse>> get() = _characters

    init {
        viewModelScope.launch {
            _characters.value = getChar()
        }
    }

    private suspend fun getChar(): List<CharacterResponse> {
        return KtorService.getCharacters().results
       // return ApiConfig.create().getCharacters().results
    }
}
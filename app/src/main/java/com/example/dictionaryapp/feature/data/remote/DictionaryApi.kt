package com.example.dictionaryapp.feature.data.remote

import com.example.dictionaryapp.feature.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word: String  //{word} in api call gets replaced by the word here
    ): List<WordInfoDto>

    companion object{
        const val BASE_URL="https://api.dictionaryapi.dev"
    }
}
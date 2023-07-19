package com.hugidonic.feature_dictionary.data.remote

import com.hugidonic.feature_dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/v2/entries/en/{word}")
    fun getWordInfo(
        @Path("word") word: String
    ): List<WordInfoDto>

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev"
    }
}
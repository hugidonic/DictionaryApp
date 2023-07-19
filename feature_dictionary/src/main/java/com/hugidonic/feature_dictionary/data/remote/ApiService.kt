package com.hugidonic.feature_dictionary.data.remote

import com.hugidonic.feature_dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET

interface ApiService {

    @GET("/api/v2/entries/en/{word}")
    fun getWordInfo(): List<WordInfoDto>
}
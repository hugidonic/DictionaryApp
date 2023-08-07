package com.hugidonic.feature_dictionary.domain.repository

import com.hugidonic.core.Resource
import com.hugidonic.feature_dictionary.domain.models.WordInfoModel
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    suspend fun getWordInfo(word: String): Flow<Resource<List<WordInfoModel>>>
}
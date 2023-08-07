package com.hugidonic.feature_dictionary.domain.usecases

import com.hugidonic.core.Resource
import com.hugidonic.feature_dictionary.domain.models.WordInfoModel
import com.hugidonic.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfoUseCase(private val repository: WordInfoRepository) {
    suspend operator fun invoke(word: String): Flow<Resource<List<WordInfoModel>>> {
        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word = word)
    }
}
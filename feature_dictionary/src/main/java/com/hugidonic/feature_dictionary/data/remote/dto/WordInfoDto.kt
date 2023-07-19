package com.hugidonic.feature_dictionary.data.remote.dto

import com.hugidonic.feature_dictionary.domain.models.WordInfoModel

data class WordInfoDto(
    val license: LicenseDto,
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
) {
    fun toWordInfoModel(): WordInfoModel = WordInfoModel(
        meanings = meanings.map {dto -> dto.toMeaningModel()},
        phonetic = phonetic,
        sourceUrls = sourceUrls,
        word = word,
    )
}
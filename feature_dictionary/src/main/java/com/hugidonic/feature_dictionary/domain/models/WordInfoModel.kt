package com.hugidonic.feature_dictionary.domain.models

data class WordInfoModel(
    val meanings: List<MeaningModel>,
    val phonetic: String,
    val sourceUrls: List<String>,
    val word: String
)

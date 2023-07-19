package com.hugidonic.feature_dictionary.domain.models

data class MeaningModel(
    val definitions: List<DefinitionModel>,
    val partOfSpeech: String,
)
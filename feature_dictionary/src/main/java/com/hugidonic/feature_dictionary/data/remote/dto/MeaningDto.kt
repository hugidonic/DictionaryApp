package com.hugidonic.feature_dictionary.data.remote.dto

import com.hugidonic.feature_dictionary.domain.models.MeaningModel

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String,
    val synonyms: List<String>,
    val antonyms: List<String>
) {
    fun toMeaningModel(): MeaningModel = MeaningModel(
        definitions = definitions.map {dto -> dto.toDefinitionModel()},
        partOfSpeech = partOfSpeech,
    )
}
package com.hugidonic.feature_dictionary.data.remote.dto

import com.hugidonic.feature_dictionary.domain.models.DefinitionModel

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
) {
    fun toDefinitionModel(): DefinitionModel = DefinitionModel(
        antonyms =  antonyms,
        definition =  definition,
        example =  example,
        synonyms = synonyms
    )
}
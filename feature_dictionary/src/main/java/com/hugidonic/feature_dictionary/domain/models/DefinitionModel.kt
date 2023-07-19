package com.hugidonic.feature_dictionary.domain.models

data class DefinitionModel(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
) {
    fun toDefinitionEntity() {

    }
}

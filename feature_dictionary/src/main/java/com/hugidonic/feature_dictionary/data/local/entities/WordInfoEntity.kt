package com.hugidonic.feature_dictionary.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hugidonic.feature_dictionary.domain.models.MeaningModel
import com.hugidonic.feature_dictionary.domain.models.WordInfoModel

@Entity(tableName = "word_info")
data class WordInfoEntity(
    val meanings: List<MeaningModel>,
    val phonetic: String,
    val word: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
) {
    fun toWordInfoModel(): WordInfoModel = WordInfoModel(
        meanings = meanings,
        phonetic = phonetic,
        word = word,
    )
}

package com.hugidonic.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.hugidonic.feature_dictionary.data.util.JsonParser
import com.hugidonic.feature_dictionary.domain.models.MeaningModel

@ProvidedTypeConverter
class Converters(
    private val parser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<MeaningModel> {
        return parser.fromJson<ArrayList<MeaningModel>>(
            json = json, type = object : TypeToken<ArrayList<MeaningModel>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningJson(meanings: List<MeaningModel>): String {
        return parser.toJson(
            obj = meanings, type = object : TypeToken<ArrayList<MeaningModel>>() {}.type
        ) ?: "[]"
    }
}
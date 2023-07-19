package com.hugidonic.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.TypeConverters
import com.hugidonic.feature_dictionary.data.local.entities.WordInfoEntity

@Database(entities = [WordInfoEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase() {
    abstract val wordInfoDao: WordInfoDao
}
package com.hugidonic.feature_dictionary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hugidonic.feature_dictionary.data.local.entities.WordInfoEntity

@Dao
interface WordInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos: List<WordInfoEntity>)

    @Query("SELECT * FROM word_info WHERE word LIKE '%' || :word || '%'")
    suspend fun getWordsInfos(word: String): List<WordInfoEntity>

    @Query("DELETE * FROM word_info WHERE word IN(:words)")
    suspend fun deleteWordInfo(words: List<String>)
}
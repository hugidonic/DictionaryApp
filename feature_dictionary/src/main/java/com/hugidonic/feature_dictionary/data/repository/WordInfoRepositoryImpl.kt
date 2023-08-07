package com.hugidonic.feature_dictionary.data.repository

import com.hugidonic.core.Resource
import com.hugidonic.feature_dictionary.data.local.WordInfoDao
import com.hugidonic.feature_dictionary.data.remote.DictionaryApiService
import com.hugidonic.feature_dictionary.domain.models.WordInfoModel
import com.hugidonic.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApiService,
    private val dao: WordInfoDao
) : WordInfoRepository {
    override suspend fun getWordInfo(word: String): Flow<Resource<List<WordInfoModel>>> = flow {
        emit(Resource.Loading())
        val cachedWordInfos = dao.getWordsInfos(word).map { entity -> entity.toWordInfoModel() }
        emit(Resource.Success(cachedWordInfos))

        try {
            val wordInfosFromApiDto = api.getWordInfo(word)
            dao.deleteWordInfo(wordInfosFromApiDto.map { it.word })
            dao.insertWordInfos(wordInfosFromApiDto.map { it.toWordInfoEntity() })

        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = cachedWordInfos
                )
            )
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server. Check your internet connection",
                    data = cachedWordInfos
                )
            )
        }

        val newWordInfosEntity = dao.getWordsInfos(word)

        emit(Resource.Success(
            data = newWordInfosEntity.map { it.toWordInfoModel() }
        ))

    }
}
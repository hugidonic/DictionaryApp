package com.hugidonic.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.hugidonic.feature_dictionary.data.local.Converters
import com.hugidonic.feature_dictionary.data.local.WordInfoDao
import com.hugidonic.feature_dictionary.data.local.WordInfoDatabase
import com.hugidonic.feature_dictionary.data.remote.DictionaryApiService
import com.hugidonic.feature_dictionary.data.repository.WordInfoRepositoryImpl
import com.hugidonic.feature_dictionary.data.util.GsonParser
import com.hugidonic.feature_dictionary.domain.repository.WordInfoRepository
import com.hugidonic.feature_dictionary.domain.usecases.GetWordInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WordInfoModule {

    @Provides
    @Singleton
    fun providesGetWordInfoUseCase(
        repository: WordInfoRepository
    ): GetWordInfoUseCase {
        return GetWordInfoUseCase(repository = repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        wordInfoApi: DictionaryApiService, wordInfoDao: WordInfoDao
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(
            api = wordInfoApi, dao = wordInfoDao
        )
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room
            .databaseBuilder(app, WordInfoDatabase::class.java, "word_db")
            .addTypeConverter(Converters(parser = GsonParser(gson = Gson())))
            .build()
    }


    @Provides
    @Singleton
    fun provideWordInfoApi(): DictionaryApiService {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(DictionaryApiService.BASE_URL)
            .build()
            .create(DictionaryApiService::class.java)
    }
}
package com.hugidonic.feature_dictionary.presentation

import com.hugidonic.feature_dictionary.domain.models.WordInfoModel

data class WordInfoState(
    val wordInfos: List<WordInfoModel> = emptyList(),
    val isLoading: Boolean = false,

)
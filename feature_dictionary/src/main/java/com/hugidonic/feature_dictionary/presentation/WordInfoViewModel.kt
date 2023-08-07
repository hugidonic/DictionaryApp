package com.hugidonic.feature_dictionary.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.core.Resource
import com.hugidonic.feature_dictionary.domain.usecases.GetWordInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordInfoViewModel @Inject constructor(
    private val getWordInfoUseCase: GetWordInfoUseCase
) : ViewModel() {

    private val _searchQuery = mutableStateOf<String>("")
    val searchQuery: State<String> = _searchQuery

    private val _lastQueries = mutableListOf<String>("Hello")
    val lastQueries: List<String> = _lastQueries

    private val _state = mutableStateOf<WordInfoState>(WordInfoState())
    val state: State<WordInfoState> = _state

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var searchJob: Job? = null


    fun onSearch(query: String) {
        _searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(SEARCH_DELAY)
            getWordInfoUseCase(query)
                .onEach {result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = _state.value.copy(
                                wordInfos = result.data ?: emptyList(),
                                isLoading = false,
                            )
                            _lastQueries.add(query)
                        }
                        is Resource.Error -> {
                            _state.value = _state.value.copy(
                                wordInfos = result.data ?: emptyList(),
                                isLoading = false,
                            )
                            _eventFlow.emit(UIEvent.ShowSnackbar(
                                message = result.message ?: "Unknown error occurred"
                            ))
                        }
                        is Resource.Loading -> {
                            _state.value = _state.value.copy(
                                wordInfos = result.data ?: emptyList(),
                                isLoading = true,
                            )
                        }
                    }
                }.launchIn(this)
        }
    }

    companion object {
        const val SEARCH_DELAY: Long = 500L
    }
}
package com.hugidonic.feature_dictionary.presentation

sealed class UIEvent {
    class ShowSnackbar(val message: String): UIEvent()
}

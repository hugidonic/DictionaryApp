package com.hugidonic.dictionaryapp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hugidonic.feature_dictionary.presentation.WordInfoViewModel
import com.hugidonic.feature_dictionary.presentation.components.SearchScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "search") {
        composable("search") {
            val viewModel = hiltViewModel<WordInfoViewModel>()
            SearchScreen(
                lastQueries = viewModel.lastQueries,
                searchValue = viewModel.searchQuery.value,
                onSearch = viewModel::onSearch,
            )
        }

        composable("word_info") {
//            WordInfo screen
        }
    }
}
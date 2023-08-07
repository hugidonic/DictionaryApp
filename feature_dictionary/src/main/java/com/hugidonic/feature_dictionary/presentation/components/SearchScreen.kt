package com.hugidonic.feature_dictionary.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.core.theme.DictionaryAppTheme
import com.hugidonic.feature_dictionary.presentation.WordInfoState

@Composable
fun SearchScreen(
    lastQueries: List<String> = emptyList(),
    searchValue: String = "",
    onSearch: (s: String) -> Unit = {},
    searchQuery: (String) -> Unit = {},
) {
    Box(
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 50.dp)
        ) {
            SearchTextField(
                searchValue = searchValue,
                onSearch = onSearch,
            )
            Spacer(modifier = Modifier.height(35.dp))
            RecentSearch(lastQueries = lastQueries)
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark",
    group = "Search Screen"
)
@Composable
fun PreviewSearchScreenDark() {
    DictionaryAppTheme {
        Surface {
            SearchScreen()
        }
    }
}

@Preview(
    name = "Light",
    group = "Search Screen"
)
@Composable
fun PreviewSearchScreenLight() {
    DictionaryAppTheme {
        Surface {
            SearchScreen()
        }
    }
}
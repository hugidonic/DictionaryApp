package com.hugidonic.feature_dictionary.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hugidonic.core.theme.DictionaryAppTheme
import com.hugidonic.feature_dictionary.presentation.WordInfoViewModel

@Composable
fun RecentSearch(
    modifier: Modifier = Modifier,
//    viewModel: WordInfoViewModel = hiltViewModel()
    lastQueries: List<String>
) {

    Column {
        Text(text = "Recent", style = MaterialTheme.typography.h2)
        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = lastQueries) { query ->
                Text(text = query,
                    style = MaterialTheme.typography.body1,
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewRecentSearchDark() {
    DictionaryAppTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            RecentSearch(
                modifier = Modifier.padding(20.dp),
                lastQueries = listOf("Hello", "Dictionary", "Modern")
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecentSearchLight() {
    DictionaryAppTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            RecentSearch(
                modifier = Modifier.padding(20.dp),
                lastQueries = listOf(
                    "Hello", "Dictionary", "Modern"
                )
            )
        }
    }
}
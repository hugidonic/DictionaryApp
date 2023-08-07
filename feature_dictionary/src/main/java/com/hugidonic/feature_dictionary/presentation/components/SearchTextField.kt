package com.hugidonic.feature_dictionary.presentation.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.hugidonic.core.theme.Black
import com.hugidonic.core.theme.DictionaryAppTheme
import com.hugidonic.feature_dictionary.presentation.WordInfoViewModel

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier, searchValue: String, onSearch: (String) -> Unit, isWordExist: Boolean = false
) {
    val textFieldBgColor = if (isSystemInDarkTheme()) Black else Color.LightGray.copy(alpha = 0.5f)
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Dictionary",
            style = MaterialTheme.typography.h1,
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = searchValue,
            onValueChange = onSearch,
            modifier = Modifier
                .fillMaxWidth()
                .background(textFieldBgColor),
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search...") },
            placeholder = {
                Text(
                    text = "Search...",
                    style = MaterialTheme.typography.body1
                )
            },
            maxLines = 1,
            singleLine = true
        )
        if (isWordExist) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(textFieldBgColor)
                    .clip(MaterialTheme.shapes.small)
                    .border(1.dp, Color.Gray)
                    .padding(start = 50.dp, top = 6.dp, bottom = 6.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = searchValue,
                    style = MaterialTheme.typography.body2
                )
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Go to the definition")
            }
        }
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "Search Text Field DARK",
)
@Composable
fun PreviewSearchTextFieldDarkUI() {
    DictionaryAppTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            SearchTextField(
                modifier = Modifier.padding(20.dp), searchValue = "Dictionary", onSearch = {}, isWordExist = true
            )
        }
    }
}

@Preview(
    showBackground = true,
    name = "Search Text Field LIGHT",
)
@Composable
fun PreviewSearchTextFieldLightUI() {
    DictionaryAppTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            SearchTextField(
                modifier = Modifier.padding(20.dp), searchValue = "Dictionary", onSearch = {}, isWordExist = true
            )
        }
    }
}
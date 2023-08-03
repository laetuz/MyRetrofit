package com.neotica.myretrofit.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.neotica.myretrofit.R
import com.neotica.myretrofit.data.local.MainViewModel

@Composable
fun LazyListMain(viewModel: MainViewModel) {
    val charactersState by viewModel.characters.collectAsState()
    LazyColumn(
        state = LazyListState(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(charactersState){
            ItemListCard(
                image = it.image,
                name = it.name,
                gender = it.gender,
                species = it.species
            ) {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemListCard(
    image: String,
    name: String,
    gender: String,
    species: String,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    alignment = Alignment.Center,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(horizontal = 10.dp),
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(
                    text = gender,
                    style = MaterialTheme.typography.titleSmall.copy(color = Color.Gray),
                )
                Text(
                    text = species,
                    style = MaterialTheme.typography.titleSmall.copy(color = Color.Gray),
                )
            }
        }
    }
}
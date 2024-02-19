package com.android.presentation.categories.screen

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage

@Composable
fun CategoriesScreen()
{
    val navController = rememberNavController()
//    val vm:CategoriesViewModel = viewModel()
    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        items(count = 5)
        {
            AsyncImage(model = "https://picsum.photos/200", contentDescription = null)
        }

    }

}

@Composable
@Preview
fun PreViewScreen()
{
    CategoriesScreen()
}
package com.example.presentation.ui.widget


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.dto.GenreItemModel
import com.example.mylibrary.R

import com.example.presentation.ui.component.Chip
import com.example.presentation.ui.component.ErrorHolder
import com.example.presentation.ui.component.LoadingIndicator
import com.example.presentation.ui.component.PlaceHolder
import com.example.presentation.ui.viewModels.GenreViewModel
import com.example.presentation.ui.viewModels.MoviesViewModel
import java.util.*


@SuppressLint("UnrememberedMutableState")
@Composable
fun GenreList(
    genreViewModel: GenreViewModel = hiltViewModel(),
    moviesViewModel: MoviesViewModel = hiltViewModel()
) {


    if (genreViewModel.genres.value.isLoading) {
        LoadingIndicator()
    }
    else if (genreViewModel.genres.value.genre.isNotEmpty()) {
        Text(
            modifier = Modifier.padding(PaddingValues(8.dp)),
            text = "Movie Category : ",
            fontWeight = FontWeight.Bold
        )
        LazyRow {
            items(genreViewModel.genres.value.genre) { genre ->
                Chip(
                    genre = genre,
                    selected = genreViewModel.selectedGenre.value == genre,
                    onSelected = {
                        if (genreViewModel.selectedGenre.value == genre)
                            genreViewModel.setSelectedGenre(GenreItemModel())
                        else
                            genreViewModel.setSelectedGenre(genre)

                    },
                    modifier = Modifier
                )
            }
        }
        if (genreViewModel.selectedGenre.value.name.isNotEmpty()) {
            moviesViewModel.getMovies(Locale.getDefault().language,genreViewModel.selectedGenre.value.id.toString())
            MovieList()
        } else {
            PlaceHolder(
                text = "Please select category",
                painter = painterResource(id = R.drawable.select)
            )
        }

    }
    else if (genreViewModel.genres.value.error.isNotEmpty()) {
        ErrorHolder(text = moviesViewModel.movies.value.error)
    }

}
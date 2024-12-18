package com.example.presentation.ui.component


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.dto.MovieItemModel
import com.example.domain.dto.MovieModel
import com.example.presentation.utiles.Constant

@Composable
fun MovieItem(movie: MovieItemModel) {

    Column {
        CoilImage(
            data = Constant.imageBaseUrl + movie.posterPath,
            contentDescription = movie.title!!,
            modifier = Modifier,
            contentScale = ContentScale.FillBounds,
        )
        Text(
            text = movie.title!!,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color(0xFF000000),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis

        )
    }
}
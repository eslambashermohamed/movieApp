package com.example.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.theme.darkWhite
import com.example.presentation.ui.component.TopBar
import com.example.presentation.ui.widget.GenreList


@SuppressLint("UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    Scaffold(
        topBar = {
            TopBar(
                title = "Home Screen",
                menu = {

                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .background(darkWhite)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it)
        ) {
            GenreList()
        }
    }


}
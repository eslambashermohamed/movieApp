package com.example.presentation.ui.viewModels


import androidx.compose.runtime.*
import androidx.lifecycle.*
import com.example.domain.dto.GenreItemModel
import com.example.domain.usecases.CategoriesUseCase
import com.example.domain.utils.GenreState
import com.example.domain.utils.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject


@HiltViewModel
class GenreViewModel @Inject constructor(
    val genreUseCase: CategoriesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(GenreState())
    private var _selectedGenre = mutableStateOf(GenreItemModel())

    val genres: State<GenreState>
        get() = _state

    val selectedGenre: State<GenreItemModel>
        get() = _selectedGenre

    fun setSelectedGenre(selectedGenre: GenreItemModel){
        _selectedGenre.value = selectedGenre
        _selectedGenre.value = _selectedGenre.value
    }


    init {
        getGenre()
    }

    private fun getGenre() {
        genreUseCase(language = Locale.getDefault().language).onEach { result ->
            when (result) {
                is Resources.Success -> {

                    _state.value = GenreState(
                        genre = result.data?.genres ?: emptyList()
                    )

                }
                is Resources.Error -> {
                    _state.value = GenreState(
                        error = result.message ?: "An unexpected error happened"
                    )
                }
                is Resources.Loading -> {
                    _state.value = GenreState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

}
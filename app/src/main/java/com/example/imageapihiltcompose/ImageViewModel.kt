package com.example.imageapihiltcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ImageViewModel @Inject constructor(
    private val repository: ImageRepository
) : ViewModel() {

    private val _image = MutableStateFlow<List<ImageItem>>(emptyList())
    val image : StateFlow<List<ImageItem>> = _image

    init {
        viewModelScope.launch {
            repository.getImages().collect{
                _image.value = it
            }
        }
    }
}
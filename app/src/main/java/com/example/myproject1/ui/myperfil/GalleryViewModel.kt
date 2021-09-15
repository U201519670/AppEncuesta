package com.example.myproject1.ui.myperfil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is myperfil Fragment"
    }
    val text: LiveData<String> = _text
}
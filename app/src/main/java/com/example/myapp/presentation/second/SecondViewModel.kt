package com.example.myapp.presentation.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.domain.AnimalUseCase
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {

    private val animalUseCase = AnimalUseCase
    val myFactFromApi = MutableLiveData<String>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getFact() {
        viewModelScope.launch {

            isLoading.postValue(true) // start loading
            myFactFromApi.postValue(animalUseCase.getFact())
            isLoading.postValue(false) // end loading

        }
    }
}
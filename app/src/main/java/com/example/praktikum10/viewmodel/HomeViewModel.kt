package com.example.praktikum10.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.praktikum10.modeldata.DataSiswa
import com.example.praktikum10.repository.RepositoryDataSiswa

sealed interface StatusUiSiswa {
    data class Success(val listSiswa: List<DataSiswa>) : StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}


class HomeViewModel (private val repositoryDataSiswa: RepositoryDataSiswa) : ViewModel(){
    var listSiswa: StatusUiSiswa by mutableStateOf(StatusUiSiswa.Loading)
        private set
    init {
        loadSiswa()
    }
}

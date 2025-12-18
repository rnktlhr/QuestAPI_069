package com.example.praktikum10.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.praktikum10.modeldata.DetailSiswa
import com.example.praktikum10.modeldata.UIStateSiswa
import com.example.praktikum10.repository.RepositoryDataSiswa

class EntryViewModel (private val repositoryDataSiswa: RepositoryDataSiswa) : ViewModel(){
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa){
        uiStateSiswa = UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }
}

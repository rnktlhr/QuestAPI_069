package com.example.praktikum10.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum10.modeldata.DetailSiswa
import com.example.praktikum10.modeldata.UIStateSiswa
import com.example.praktikum10.modeldata.toDataSiswa
import com.example.praktikum10.modeldata.toUiStateSiswa
import com.example.praktikum10.repository.RepositoryDataSiswa
import com.example.praktikum10.uicontroler.route.DestinasiEdit
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryDataSiswa: RepositoryDataSiswa
): ViewModel(){

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    // AMBIL ID: Pastikan menggunakan DestinasiEdit.itemIdArg
    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiEdit.itemIdArg])

    init {
        viewModelScope.launch {
            try {
                // LOAD DATA LAMA: Agar form terisi data lama saat layar edit dibuka
                val siswa = repositoryDataSiswa.getSatuSiswa(idSiswa)
                uiStateSiswa = siswa.toUiStateSiswa(true)
            } catch (e: Exception) {
                Log.e("EditViewModel", "Gagal load data: ${e.message}")
            }
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa){
        uiStateSiswa = UIStateSiswa(
            detailSiswa = detailSiswa,
            isEntryValid = (detailSiswa.nama.isNotBlank() && detailSiswa.alamat.isNotBlank() && detailSiswa.telpon.isNotBlank())
        )
    }

    suspend fun editSatuSiswa() {
        try {
            repositoryDataSiswa.editSatuSiswa(idSiswa, uiStateSiswa.detailSiswa.toDataSiswa())
        } catch (e: Exception) {
            Log.e("EditViewModel", "Gagal Update Database")
        }
    }
}
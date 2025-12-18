package com.example.praktikum10.viewmodel

import com.example.praktikum10.modeldata.DataSiswa

sealed interface StatusUiSiswa {
    data class Success(val listSiswa: List<DataSiswa>) : StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}


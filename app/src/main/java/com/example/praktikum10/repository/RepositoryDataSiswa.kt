package com.example.praktikum10.repository

import com.example.praktikum10.modeldata.DataSiswa

interface RepositoryDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDatasiswa(dataSiswa: DataSiswa):retrofit2.Response<Void>
}


package com.example.praktikum10.repository

import com.example.praktikum10.apiservice.ServiceApiSiswa
import com.example.praktikum10.modeldata.DataSiswa

interface RepositoryDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDatasiswa(dataSiswa: DataSiswa):retrofit2.Response<Void>
}

class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
): RepositoryDataSiswa {
    override suspend fun getDataSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()
    override suspend fun postDatasiswa(dataSiswa: DataSiswa):retrofit2.Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
}
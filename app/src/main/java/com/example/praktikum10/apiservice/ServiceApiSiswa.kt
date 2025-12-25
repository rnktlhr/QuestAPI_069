package com.example.praktikum10.apiservice

import com.example.praktikum10.modeldata.DataSiswa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApiSiswa{
    @GET("bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertTM.php")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): Response<Void>

    @GET("baca1teman.php")
    suspend fun getSatuSiswa(@Query("id") id: Int): DataSiswa

    @PUT("edit.php")
    suspend fun editSatuSiswa(@Query("id") id: Int, @Body dataSiswa: DataSiswa): Response<Void>

    @DELETE("deleteTM.php")
    suspend fun hapusSatuSiswa(@Query("id") id: Int): Response<Void>
}
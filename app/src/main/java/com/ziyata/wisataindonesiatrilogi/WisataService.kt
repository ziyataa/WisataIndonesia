package com.ziyata.wisataindonesiatrilogi

import retrofit2.Call
import retrofit2.http.GET

interface WisataService {

    @GET("?action=findAll")
    fun requestAmbil():Call<ResponseServer>

}
package com.example.myapp.data.remote

import com.example.myapp.data.remote.model.MyAnimalAPIModel
import retrofit2.Response
import retrofit2.http.GET

interface AnimalAPIInterface {

    @GET("/?count=1")
    suspend fun getAnimal(): Response<MyAnimalAPIModel>


}
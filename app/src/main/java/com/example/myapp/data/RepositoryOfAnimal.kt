package com.example.myapp.data

import com.example.myapp.data.remote.APIFactory
import com.example.myapp.data.remote.model.MyAnimalAPIModel

object RepositoryOfAnimal {
    private val api = APIFactory.animalApi

    suspend fun getAnimal(): MyAnimalAPIModel? {

        //val parameters = HashMap<String, String>()
        //parameters.put("facts", "1")
        val response = api.getAnimal()

        if (response.isSuccessful) {
            if (response.body() != null) {
                val body = response.body()
                return body!!
            }
        }
        return null
    }
}
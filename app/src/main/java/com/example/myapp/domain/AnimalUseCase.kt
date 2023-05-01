package com.example.myapp.domain

import com.example.myapp.data.RepositoryOfAnimal

object AnimalUseCase {
    private val remoteRepo = RepositoryOfAnimal

    suspend fun getFact(): String{
        return remoteRepo.getAnimal()?.data?.get(0).toString() // Повертаємо 1 факт з репозиторію
    }
}
package com.example.burgershub.data.repository

import com.example.burgershub.data.model.BurgerDTO
import com.example.burgershub.domain.repository.BurgerRepository

class BurgerRepositoryImpl : BurgerRepository{
  override suspend fun getBurgers(): List<BurgerDTO> {
    TODO("Not yet implemented")
  }

  override suspend fun getBurgerById(burgerId: Int): BurgerDTO {
    TODO("Not yet implemented")
  }

  override suspend fun getBurgerByName(burgerName: String): List<BurgerDTO> {
    TODO("Not yet implemented")
  }
}
package com.example.burgershub.data.repository

import com.example.burgershub.data.api.ServiceAPI
import com.example.burgershub.data.model.BurgerDTO
import com.example.burgershub.domain.repository.BurgerRepository
import javax.inject.Inject

class BurgerRepositoryImpl @Inject constructor(
  private val serviceAPI: ServiceAPI
) : BurgerRepository{
  override suspend fun getBurgers(): List<BurgerDTO> {
    return serviceAPI.getBurgers()
  }

  override suspend fun getBurgerById(burgerId: Int): BurgerDTO {
    return serviceAPI.getBurgerById(burgerId)
  }

  override suspend fun getBurgerByName(burgerName: String): List<BurgerDTO> {
    return serviceAPI.getBurgerByName(burgerName)
  }
}
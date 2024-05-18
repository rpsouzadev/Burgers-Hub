package com.example.burgershub.domain.repository

import com.example.burgershub.data.model.BurgerDTO

interface BurgerRepository {

  suspend fun getBurgers(): List<BurgerDTO>

  suspend fun getBurgerById(burgerId: String): BurgerDTO

  suspend fun getBurgerByName(burgerName: String): List<BurgerDTO>
}
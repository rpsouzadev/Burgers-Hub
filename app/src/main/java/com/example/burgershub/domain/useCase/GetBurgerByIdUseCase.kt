package com.example.burgershub.domain.useCase

import com.example.burgershub.data.mapper.toDomain
import com.example.burgershub.domain.model.Burger
import com.example.burgershub.domain.repository.BurgerRepository
import javax.inject.Inject

class GetBurgerByIdUseCase @Inject constructor(
  private val burgerRepository: BurgerRepository
) {

  suspend operator fun invoke(burgerId: String): Burger {
    return burgerRepository.getBurgerById(burgerId).toDomain()
  }

}
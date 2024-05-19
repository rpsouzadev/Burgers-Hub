package com.example.burgershub.domain.useCase

import com.example.burgershub.data.mapper.toDomain
import com.example.burgershub.domain.model.Burger
import com.example.burgershub.domain.repository.BurgerRepository
import javax.inject.Inject

class GetBurgerByNameUseCase @Inject constructor(
  private val burgerRepository: BurgerRepository
) {

  suspend operator fun invoke(nameBurger: String): List<Burger> {
    return burgerRepository.getBurgerByName(nameBurger).map { it.toDomain() }.filter {
      it.name?.contains(nameBurger, true) == true
    }
  }

}
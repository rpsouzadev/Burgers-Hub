package com.example.burgershub.domain.useCase

import com.example.burgershub.data.model.BurgerDTO
import com.example.burgershub.domain.repository.BurgerRepository
import javax.inject.Inject

class GetBurgerByNameUseCase @Inject constructor(
  private val burgerRepository: BurgerRepository
) {

  suspend operator fun invoke(nameBurger: String): List<BurgerDTO> {
    return burgerRepository.getBurgerByName(nameBurger)
  }

}
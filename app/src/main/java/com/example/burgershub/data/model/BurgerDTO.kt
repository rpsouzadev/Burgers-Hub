package com.example.burgershub.data.model

data class BurgerDTO(
  val id: Int?,
  val desc: String?,
  val images: List<ImageDTO>?,
  val ingredients: List<IngredientDTO>?,
  val name: String?,
  val price: Double?,
  val veg: Boolean?,
)

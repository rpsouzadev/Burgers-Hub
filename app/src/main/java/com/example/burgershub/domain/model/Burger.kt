package com.example.burgershub.domain.model

data class Burger(
  val id: Int?,
  val desc: String?,
  val images: List<Image>?,
  val ingredients: List<Ingredient>?,
  val name: String?,
  val price: Double?,
  val veg: Boolean?,
)

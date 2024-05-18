package com.example.burgershub.domain.model

data class Burger(
  val id: String?,
  val desc: String?,
  val images: List<Image>?,
  val ingredients: List<Ingredient>?,
  val name: String?,
  val price: Float?,
  val veg: Boolean?,
)

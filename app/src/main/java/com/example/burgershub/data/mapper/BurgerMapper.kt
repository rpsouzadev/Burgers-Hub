package com.example.burgershub.data.mapper

import com.example.burgershub.data.model.BurgerDTO
import com.example.burgershub.data.model.ImageDTO
import com.example.burgershub.data.model.IngredientDTO
import com.example.burgershub.domain.model.Burger
import com.example.burgershub.domain.model.Image
import com.example.burgershub.domain.model.Ingredient

fun BurgerDTO.toDomain() = Burger(
  id = this.id,
  veg = this.veg,
  desc = this.desc,
  name = this.name,
  price = this.price,
  images = this.images?.map { it.toDomain() },
  ingredients = this.ingredients?.map { it.toDomain() }
)

fun ImageDTO.toDomain() = Image(
  lg = this.lg,
  sm = this.sm,
)

fun IngredientDTO.toDomain() = Ingredient(
  id = this.id,
  img = this.img,
  name = this.name,
)
package com.example.burgershub.data.api

import com.example.burgershub.data.model.BurgerDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceAPI {

  @GET("burgers")
  suspend fun getBurgers(): List<BurgerDTO>

  @GET("burgers/{burger_id}")
  suspend fun getBurgerById(@Path("burger_id") burgerId: String): BurgerDTO

  @GET("find-burger/")
  suspend fun getBurgerByName(@Query("searchQuery=q&search") burgerName: String): List<BurgerDTO>
}
package com.example.burgershub.data.api

import com.example.burgershub.data.model.BurgerDTO
import io.github.brunogabriel.mockpinterceptor.MOCK
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceAPI {

  @MOCK(asset = "burgers_response.json", runDelay = true)
  @GET("burgers")
  suspend fun getBurgers(): List<BurgerDTO>

  @MOCK(asset = "burger_response.json", runDelay = true)
  @GET("burgers/{burger_id}")
  suspend fun getBurgerById(@Path("burger_id") burgerId: Int): BurgerDTO

  @MOCK(asset = "burger_name_response.json", runDelay = true)
  @GET("find-burger/")
  suspend fun getBurgerByName(@Query("search") burgerName: String): List<BurgerDTO>
}
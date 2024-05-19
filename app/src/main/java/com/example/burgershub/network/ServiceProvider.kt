package com.example.burgershub.network

import com.example.burgershub.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit


class ServiceProvider {
  private val baseUrl = "https://burgers-hub.p.rapidapi.com/"

  private val client = OkHttpClient.Builder()
    .connectTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .addInterceptor(HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    })
    .addInterceptor(Interceptor { chain ->
      chain.run {
        proceed(
          request()
            .newBuilder()
            .addHeader(
              name = "X-RapidAPI-Key",
              value = BuildConfig.RAPIDAPI_KEY,
            )
            .build()
        )

      }
    })
    .build()

  private val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()

  fun <API> createService(apiClass: Class<API>): API = retrofit.create(apiClass)
}
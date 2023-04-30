package com.negreiros.caseintelbras.rest

import AuthorizationInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientApi {
    private val baseURL = "http://squadapps.ddns-intelbras.com.br:3000/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .client(createOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService(): RetrofitService{
        return retrofit.create(RetrofitService::class.java)
    }

    private fun createOkHttpClient(): OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(AuthorizationInterceptor("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImIwNmM5NGYzLWI2YTQtNDFmMi1hNThjLTU1ZGY2ZjJkMDI0NSIsImlhdCI6MTY4MjAwOTYxNSwiZXhwIjoxNjg0NjAxNjE1fQ.3dVKcdj2uZ1ly88awhqqdfRMynBw4BqLy9EE5e3cR-g"))
            .build()

        return client
    }
}
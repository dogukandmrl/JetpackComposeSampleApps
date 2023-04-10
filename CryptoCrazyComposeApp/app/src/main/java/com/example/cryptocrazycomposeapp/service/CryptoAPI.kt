package com.example.cryptocrazycomposeapp.service

import com.example.cryptocrazycomposeapp.model.Crypto
import com.example.cryptocrazycomposeapp.model.CryptoList
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoAPI {

    @GET("prices")
    suspend fun getCryptoList(
        @Query("key") key: String
    ): CryptoList

    @GET("currencies")
    suspend fun getCrypto(
        @Query("key") key:String,
        @Query("ids") id:String,
        @Query("attributes") attributes:String
    ): Crypto
}
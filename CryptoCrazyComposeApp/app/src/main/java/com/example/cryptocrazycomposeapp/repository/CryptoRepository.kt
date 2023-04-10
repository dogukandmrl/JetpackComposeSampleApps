package com.example.cryptocrazycomposeapp.repository

import com.example.cryptocrazycomposeapp.model.Crypto
import com.example.cryptocrazycomposeapp.model.CryptoList
import com.example.cryptocrazycomposeapp.service.CryptoAPI
import com.example.cryptocrazycomposeapp.util.Constants.API_KEY
import com.example.cryptocrazycomposeapp.util.Constants.CALL_ATTRIBUTES
import com.example.cryptocrazycomposeapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api: CryptoAPI
) {
    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList(API_KEY)
        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }
    suspend fun getCrypto(id:String): Resource<Crypto> {
        val response = try {
            api.getCrypto(API_KEY,id,CALL_ATTRIBUTES)
        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }

}
package com.example.cryptocrazycomposeapp.viewmodel


import androidx.lifecycle.ViewModel
import com.example.cryptocrazycomposeapp.model.Crypto
import com.example.cryptocrazycomposeapp.repository.CryptoRepository
import com.example.cryptocrazycomposeapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {
    suspend fun getCrypto(id: String): Resource<Crypto> {
        return repository.getCrypto(id)
    }
}
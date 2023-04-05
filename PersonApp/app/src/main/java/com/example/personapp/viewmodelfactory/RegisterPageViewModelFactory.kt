package com.example.personapp.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.personapp.viewmodel.PersonRegisterViewModel

class RegisterPageViewModelFactory (var application: Application) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonRegisterViewModel(application) as T
    }
}
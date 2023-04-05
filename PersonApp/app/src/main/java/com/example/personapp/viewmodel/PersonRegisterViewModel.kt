package com.example.personapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.personapp.repo.PersonDaoRepository

class PersonRegisterViewModel (application: Application): AndroidViewModel(application) {
    var personRepo= PersonDaoRepository(application)

    fun register(personName:String,personNumber:String){
        personRepo.personRegister(personName,personNumber)
    }

}
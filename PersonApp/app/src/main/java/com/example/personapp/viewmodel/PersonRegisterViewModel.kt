package com.example.personapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.personapp.repo.PersonDaoRepository

class PersonRegisterViewModel : ViewModel() {
    var personRepo= PersonDaoRepository()

    fun register(personName:String,personNumber:String){
        personRepo.personRegister(personName,personNumber)
    }

}
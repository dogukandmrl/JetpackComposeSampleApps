package com.example.personapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.personapp.repo.PersonDaoRepository

class DetailPageViewModel : ViewModel() {
    var personRepo= PersonDaoRepository()
    fun update (personId:Int,personName:String,personNumber:String){
        personRepo.personUpdate(personId,personName,personNumber)
    }
}
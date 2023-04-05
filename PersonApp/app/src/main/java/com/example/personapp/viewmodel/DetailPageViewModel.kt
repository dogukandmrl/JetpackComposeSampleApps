package com.example.personapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.personapp.repo.PersonDaoRepository

class DetailPageViewModel (application: Application): AndroidViewModel(application) {
    var personRepo= PersonDaoRepository(application)
    fun update (personId:Int,personName:String,personNumber:String){
        personRepo.personUpdate(personId,personName,personNumber)
    }
}
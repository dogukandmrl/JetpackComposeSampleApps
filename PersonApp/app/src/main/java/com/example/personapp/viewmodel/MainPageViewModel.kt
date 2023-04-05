package com.example.personapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.personapp.entity.Person
import com.example.personapp.repo.PersonDaoRepository

class MainPageViewModel(application: Application):AndroidViewModel(application) {
    var personRepo= PersonDaoRepository(application)
    var personList = MutableLiveData<List<Person>>()
    init {
        setContact()
        personList = personRepo.getPerson()
    }

    fun setContact(){
    personRepo.setAllPerson()
    }

    fun search(searchWord:String){
    personRepo.searchPerson(searchWord)
    }

    fun delete(personId:Int){
    personRepo.personDelete(personId)
    }
}
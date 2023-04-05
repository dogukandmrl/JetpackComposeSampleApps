package com.example.personapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.personapp.entity.Person
import com.example.personapp.repo.PersonDaoRepository

class MainPageViewModel : ViewModel() {
    var personRepo= PersonDaoRepository()
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
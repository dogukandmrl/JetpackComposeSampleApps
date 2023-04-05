package com.example.personapp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.personapp.entity.Person

class PersonDaoRepository {
    var personList = MutableLiveData<List<Person>>()

    init {
        personList=MutableLiveData()
    }
    fun getPerson():MutableLiveData<List<Person>>{
     return personList
    }
    fun setAllPerson(){
        val list = mutableListOf<Person>()
        val person1 = Person(1, "Ahmet", "11111")
        val person2 = Person(2, "Zeynep", "22222")
        list.add(person1)
        list.add(person2)
        personList.value= list
    }
    fun searchPerson(searched:String){
        Log.e("Person Search",searched)
    }
    fun personRegister(personName:String, personNumber:String){
        Log.e("Person Register","$personName - $personNumber")
    }
    fun personUpdate(personId:Int, personName:String, personNumber: String){
        Log.e("Person Update","$personName - $personNumber - $personId")
    }
    fun personDelete(personId: Int){
        Log.e("Person delete","$personId")
    }
}
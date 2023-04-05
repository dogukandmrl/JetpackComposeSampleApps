package com.example.personapp.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.personapp.entity.Person
import com.example.personapp.room.DataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PersonDaoRepository(var application: Application) {
    var personList = MutableLiveData<List<Person>>()
    var db:DataBase
    init {
        db = DataBase.databaseAccess(application)!!
        personList=MutableLiveData()
    }
    fun getPerson():MutableLiveData<List<Person>>{
     return personList
    }
    fun setAllPerson(){
      val job: Job = CoroutineScope(Dispatchers.Main).launch{
          personList.value= db.personDao().allPerson()
      }
    }
    fun searchPerson(searched:String){
        val job: Job = CoroutineScope(Dispatchers.Main).launch{
            personList.value= db.personDao().searchPerson(searched)
        }
    }
    fun personRegister(personName:String, personNumber:String){
       val job: Job= CoroutineScope(Dispatchers.Main).launch {
           val newPerson = Person(0,personName,personNumber)
           db.personDao().addPerson(newPerson)
       }
    }
    fun personUpdate(personId:Int, personName:String, personNumber: String){
        val job: Job= CoroutineScope(Dispatchers.Main).launch {
            val updatedPerson = Person(personId,personName,personNumber)
            db.personDao().updatePerson(updatedPerson)
        }
    }
    fun personDelete(personId: Int){
        val job: Job= CoroutineScope(Dispatchers.Main).launch {
            val deletedPerson = Person(personId,"","")
            db.personDao().deletePerson(deletedPerson)
            setAllPerson()
        }
    }
}
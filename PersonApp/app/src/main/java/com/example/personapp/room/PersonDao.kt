package com.example.personapp.room

import androidx.room.*
import com.example.personapp.entity.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    suspend fun allPerson(): List<Person>

    @Insert
    suspend fun addPerson(person: Person)

    @Update
    suspend fun updatePerson(person: Person)

    @Delete
    suspend fun deletePerson(person: Person)

    @Query("SELECT * FROM person WHERE person_name like '%'||:searchWord||'%' ")
    suspend fun searchPerson(searchWord:String):List<Person>
}
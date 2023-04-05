package com.example.personapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.personapp.entity.Person

@Database(entities = [Person::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {
        var INSTANCE: DataBase? = null

        fun databaseAccess(context: Context): DataBase? {
            if (INSTANCE == null) {
                synchronized(DataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java, "contact.sqlite"
                    ).createFromAsset("contact.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}
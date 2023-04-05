package com.example.personapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "person")
data class Person(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id") @NotNull var personId: Int,
    @ColumnInfo(name = "person_name") @NotNull var personName: String,
    @ColumnInfo(name = "person_number") @NotNull var personNumber: String
) {


}
package com.example.marks.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    var id :Int = 0,
    var password_student:String,

    var name_student :String)
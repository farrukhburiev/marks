package com.example.marks.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Teacher(
    @PrimaryKey(autoGenerate = true)
    var id_teacher :Int = 0,
    var password_teacher:String,
    var name_teacher:String,


    )
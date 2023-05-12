package com.example.marks.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marks.model.Subject

@Entity
data class Teacher(
    @PrimaryKey(autoGenerate = true)
    var id :Int = 0,
    var password_teacher:String,
    var name_teacher:String,
    var subject: Subject

    )
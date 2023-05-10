package com.example.marks.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    var teacher: Teacher,

    var name_subject: String
)
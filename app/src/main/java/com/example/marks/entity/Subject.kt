package com.example.marks.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject(
    @PrimaryKey(autoGenerate = true)
    var id_subject :Int = 0,
    var subject_name :String,


    )
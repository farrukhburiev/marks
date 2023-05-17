package com.example.marks.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Group
    (    @PrimaryKey(autoGenerate = true)
    var id_group:Int = 0,
    var group_name : String
)
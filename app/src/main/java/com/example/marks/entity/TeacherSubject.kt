package com.example.marks.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Subject::class,
            parentColumns = ["subject_id"],
            childColumns = ["subject"]
        )
    ]
)
class TeacherSubject(
    @PrimaryKey(autoGenerate = true)
    var id_teacher_subject: Int= 0 ,
    var subject_id: Int
)
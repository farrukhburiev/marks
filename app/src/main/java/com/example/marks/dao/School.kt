package com.example.marks.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marks.entity.Student
import com.example.marks.entity.Teacher

@Dao
interface School {
//  @Query("select password_student,name_student from student union all select password_teacher,name_teacher from teacher")

    @Insert
    fun addStudent(student: Student)

    @Insert
    fun addTeacher(teacher: Teacher)

    @Query("select * from teacher")
    fun getAllTeachers(): List<Teacher>

    @Query("select * from student")
    fun getAllStudents(): List<Student>
}
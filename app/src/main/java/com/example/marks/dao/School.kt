package com.example.marks.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marks.entity.Student
import com.example.marks.entity.Subject
import com.example.marks.entity.Teacher
import com.example.marks.entity.TeacherSubject

@Dao
interface School {
//  @Query("select password_student,name_student from student union all select password_teacher,name_teacher from teacher")

    @Insert
    fun addStudent(student: Student)

    @Insert
    fun addTeacher(teacher: Teacher)

    @Insert
    fun addSubject(subject: Subject)

    @Query("select * from teacher")
    fun getAllTeachers(): List<Teacher>

    @Insert
    fun addTeacherSubject(teacherSubject: TeacherSubject)

//    @Query("select id_subject , id_teacher from subject,teacher where id_teacher = id_subject")
//    fun addTeacherToSubject():List<TeacherSubject>

    //    @Query("select id_subject,id_teacher from subject,teacher where id_subject = id_teacher")
    //    fun getSubjectById(id: Int): List<Teacher>

    @Query("select * from subject")
    fun getAllSubjects(): List<Subject>

    @Query("select * from student")
    fun getAllStudents(): List<Student>
}
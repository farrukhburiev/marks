package com.example.marks.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marks.dao.School
import com.example.marks.entity.Student
import com.example.marks.entity.Subject
import com.example.marks.entity.Teacher
import com.example.marks.entity.TeacherSubject


@Database(entities = [Student::class,Teacher::class,Subject::class,TeacherSubject::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getUserDao():School

    companion object{
        var instance:AppDatabase? = null

        fun getInstance(context:Context):AppDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(context,AppDatabase::class.java,"app_db")
                    .allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
}
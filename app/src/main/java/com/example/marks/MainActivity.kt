package com.example.marks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marks.databinding.ActivityMainBinding
import com.example.marks.screen.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.beginTransaction().add(R.id.main_activity,LoginFragment())

        setContentView(binding.root)
    }
}
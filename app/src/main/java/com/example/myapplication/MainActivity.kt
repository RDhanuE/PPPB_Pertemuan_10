package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            rvStudent.apply {
                adapter = StudentAdapater(generateStudentData()) { student ->
                    Toast.makeText(
                        this@MainActivity,
                        "This is ${student.name}, and he/she likes to ${student.hobby}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

    }

    fun generateStudentData() : List<Student>{
        return listOf(
            Student(name = "Someone1", hobby = "Something1"),
            Student(name = "Someone2", hobby = "Something2"),
            Student(name = "Someone3", hobby = "Something3"),
            Student(name = "Someone4", hobby = "Something4")
        )
    }
}
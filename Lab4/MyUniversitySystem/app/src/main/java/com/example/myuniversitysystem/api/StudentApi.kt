package com.example.myuniversitysystem.api

import com.example.myuniversitysystem.model.Student

interface StudentApi {

    fun getStudents(): List<Student>

    fun addStudent(student: Student)

    fun deleteStudent(id: Int)
}

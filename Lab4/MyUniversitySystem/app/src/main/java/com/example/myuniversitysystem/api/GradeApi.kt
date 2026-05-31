package com.example.myuniversitysystem.api

import com.example.myuniversitysystem.model.Grade

interface GradeApi {

    fun getGrades(): List<Grade>

    fun addGrade(grade: Grade)

    fun deleteGrade(id: Int)
}

package com.example.myuniversitysystem.api

import com.example.myuniversitysystem.model.Course

interface CourseApi {

    fun getCourses(): List<Course>

    fun addCourse(course: Course)

    fun deleteCourse(id: Int)
}

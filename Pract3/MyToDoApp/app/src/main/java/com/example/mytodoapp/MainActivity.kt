package com.example.mytodoapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTask = findViewById<EditText>(R.id.editTask)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val taskList = findViewById<ListView>(R.id.taskList)

        val tasks = ArrayList<String>()

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            tasks
        )

        taskList.adapter = adapter

        btnAdd.setOnClickListener {

            val task = editTask.text.toString()

            if (task.isNotEmpty()) {
                tasks.add(task)
                adapter.notifyDataSetChanged()
                editTask.text.clear()
            }
        }

        taskList.setOnItemClickListener { _, _, position, _ ->

            tasks[position] = "✓ " + tasks[position]
            adapter.notifyDataSetChanged()
        }
    }
}

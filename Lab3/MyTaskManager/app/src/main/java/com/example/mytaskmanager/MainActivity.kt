package com.example.mytaskmanager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

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

            AlertDialog.Builder(this)
                .setTitle("Деталі задачі")
                .setMessage(tasks[position])
                .setPositiveButton("OK", null)
                .show()
        }

        taskList.setOnItemLongClickListener { _, _, position, _ ->

            val editText = EditText(this)
            editText.setText(tasks[position])

            AlertDialog.Builder(this)
                .setTitle("Редагування задачі")
                .setView(editText)

                .setPositiveButton("Зберегти") { _, _ ->

                    tasks[position] = editText.text.toString()
                    adapter.notifyDataSetChanged()
                }

                .setNeutralButton("Виконано") { _, _ ->

                    if (!tasks[position].startsWith("✓ ")) {
                        tasks[position] = "✓ " + tasks[position]
                        adapter.notifyDataSetChanged()
                    }
                }

                .setNegativeButton("Видалити") { _, _ ->

                    tasks.removeAt(position)
                    adapter.notifyDataSetChanged()
                }

                .show()

            true
        }
    }
}
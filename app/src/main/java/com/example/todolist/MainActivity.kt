package com.example.todolist

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //attaching adapterTodo to our recyclerView
    private lateinit var adapter: ToDoAdapter
    /*private var todow = mutableListOf<ToDow>()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //attaching adapterTodo to our recyclerView
        adapter =  ToDoAdapter(this)
        binding.rvTodo.adapter = adapter
        binding.rvTodo.layoutManager = LinearLayoutManager(this)

        binding.AddBtn.setOnClickListener {
            val i = binding.addTodoText.text.toString()
            Log.d(TAG,"Add button check")
            if(i.isEmpty()){
                binding.addTodoText.text.clear()
            } else{
                val a = ToDo(i)
                adapter.addToDo(a)
                binding.addTodoText.text.clear()

            }
        }
        binding.deleteBtn.setOnClickListener {
            adapter.deleteTodo()
        }
    }

}
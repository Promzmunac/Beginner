package com.example.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemListBinding

class ToDoAdapter(private val context: Context):RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>(){
    private var todos = mutableListOf<ToDo>()

    inner class TodoViewHolder( var binding: ItemListBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
       //inflate the the view of item list binding and return viewHolder object containing this layout
        val  layout = ItemListBinding.inflate(LayoutInflater.from(context), parent,false)
        return TodoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
       val current = todos[position]
        holder.binding.checkBox.isChecked = current.isChecked
        holder.binding.textTittle.text = current.title

    }

    //return the size of the todos list
    override fun getItemCount(): Int {
        return todos.size
    }

    //function that strikes through the tittle rv if the user isChecked is true
    /*private fun toggleStrikeThrough(strike: TextView, isChecked : Boolean ){
        if (isChecked){
            strike.paintFlags = strike.paintFlags or STRIKE_THRU_TEXT_FLAG

        } else {
            strike.paintFlags = strike.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()  //.inv

        }
    }*/
    fun addToDo(todo: ToDo){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }

    fun deleteTodo(){
        todos.removeAll { todos ->

            todos.isChecked
        }
    }

}
package com.ikpydev.todoapp

import android.text.Spannable
import android.text.SpannableString
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikpydev.todoapp.MainActivity.TasksList
import com.ikpydev.todoapp.databinding.ItemTaskBinding

class TaskAdapter(private val tasks: List<TasksList>) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: TasksList) = with(binding) {
            hours.text = task.hours

            if (task.checked) {
                checked.isChecked = true
                val ss = SpannableString(task.text)
                ss.setSpan(
                    StrikethroughSpan(),
                    0,
                    task.text.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                tasked.text = ss
            } else {
                checked.isChecked = false
                tasked.text = task.text
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(tasks[position])
    }
}
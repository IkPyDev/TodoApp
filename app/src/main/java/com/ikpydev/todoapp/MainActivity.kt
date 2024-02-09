package com.ikpydev.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ikpydev.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adabter = listOf<TasksList>(
            TasksList(true,"8:00 AM","Go to church"),
            TasksList(true,"12:00 PM","Cook for the family"),
            TasksList(true,"2:00 PM","Wash my clothes"),
            TasksList(false,"5:00 PM","Visit Chastity"),
            TasksList(true,"6:00 PM","Make my hair"),
            TasksList(false,"8:00 PM","Call my brother"),
        )



        Glide.with(binding.root)
            .load(avatar)
            .placeholder(R.drawable.ic_girl)
            .circleCrop()
            .into(binding.avatar)

        binding.task.adapter = TaskAdapter(adabter)


    }


    data class TasksList(
        val checked: Boolean, val hours: String,
        val text: String
    )

    companion object{
        const val avatar = "https://s3-alpha-sig.figma.com/img/4d5b/164c/45f66de2e968ddae74a201b09b3d02c4?Expires=1708300800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=KAQXBxZbYSPkkQZe0w~9cm0qd16ldHPKBUXUGpQnxPl0xJq7G0DATuMRG-VE9JnsyS7fEww-3uUWT1LFkX0RePnnnfDp1vrpXJmVoIIoTrmwHDhxmsnLFASXFjPTflHR7vuVvPDXEEJTj8zSYEg0~iUclbq-zusi-UC7JOp~7hqFh3e1EVCAwQwbjyxL1XRNRa5khxVtmzjYJN-ZyGRXhCPtafjGn8Kimr1~W25l9KiOC-AFTub~56vovaAPoRuziKgBA~GMasWiIvEf8WKvbSrUHtaAKb~YQCuzBgwOAruss8VrwA2ZUeMJqsxgVxblkxOmKqGaEK2Pz3e9RlSNkg__"
    }
}
package com.app_devs.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app_devs.diffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: StudentAdapter
    private val list=ArrayList<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        list.add(Student(0,"Sumit",21))
        list.add(Student(1,"Aditya",24))
        list.add(Student(2,"Ashutosh",25))
        myAdapter= StudentAdapter()
        binding.rv.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            val decoration=DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            myAdapter.setData(list)
            adapter=myAdapter
        }
        binding.button.setOnClickListener {
            list.add(Student(3,"Yash",21))
            myAdapter.setData(list)
        }
        setContentView(binding.root)
    }
}
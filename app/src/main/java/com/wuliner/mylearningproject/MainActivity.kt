package com.wuliner.mylearningproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.wuliner.mylearningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val data = listOf("Appple", "Banana", "Orange", "Watermelon", "Pear",
        "Grape", "PineAple", "Strawberry", "Cherry", "Mango", "Appple", "Banana",
        "Orange", "Watermelon", "Pear", "Grape", "PineAple", "Strawberry", "Cherry", "Mango")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        binding.listView.adapter = adapter

        setContentView(binding.root)
    }
}
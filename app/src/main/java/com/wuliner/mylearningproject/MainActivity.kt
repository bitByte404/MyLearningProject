package com.wuliner.mylearningproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.wuliner.mylearningproject.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val data = listOf("Appple", "Banana", "Orange", "Watermelon", "Pear",
        "Grape", "PineAple", "Strawberry", "Cherry", "Mango", "Appple", "Banana",
        "Orange", "Watermelon", "Pear", "Grape", "PineAple", "Strawberry", "Cherry", "Mango")

    private val fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initRandomFruits()//初始化水果数据
        /***
         * 创建了一个StaggeredGridLayoutManager的实例
         * 第一个参数用于指定布局的列数，传入3表示将布局分为3列
         * 第二个参数用于指定布局的排列方向，传入StaggeredGridLayoutManager.VERTICAL，表示会将布局纵向排列
         */
//        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
//        binding.recyclerView.layoutManager = layoutManager
//        val adapter = RecyclerFruitAdapter(fruitList)
//        binding.recyclerView.adapter = adapter

        val adapter = RecyclerFruitAdapter(fruitList)
        binding.viewPager.adapter = adapter
        setContentView(binding.root)
    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango", R.drawable.mango_pic))
        }
    }

    private fun  initRandomFruits() {
        repeat(2) {
            fruitList.add(Fruit(getRandomLengthString("Apple"), R.drawable.apple_pic))
            fruitList.add(Fruit(getRandomLengthString("Banana"), R.drawable.banana_pic))
            fruitList.add(Fruit(getRandomLengthString("Orange"), R.drawable.orange_pic))
            fruitList.add(Fruit(getRandomLengthString("Watermelon"), R.drawable.watermelon_pic))
            fruitList.add(Fruit(getRandomLengthString("Pear"), R.drawable.pear_pic))
            fruitList.add(Fruit(getRandomLengthString("Grape"), R.drawable.grape_pic))
            fruitList.add(Fruit(getRandomLengthString("Pineapple"), R.drawable.pineapple_pic))
            fruitList.add(Fruit(getRandomLengthString("Cherry"), R.drawable.cherry_pic))
            fruitList.add(Fruit(getRandomLengthString("Mango"), R.drawable.mango_pic))
        }
    }

    /**
     * 将子项的文字高度改为不同，使得效果更加明显
     */
    private fun getRandomLengthString(str: String): String {
        val n = (1..20).random()
        Log.v("test", "$n")
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }
}
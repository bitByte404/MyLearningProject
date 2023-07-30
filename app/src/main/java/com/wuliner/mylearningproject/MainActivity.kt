package com.wuliner.mylearningproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.wuliner.mylearningproject.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val fruits = mutableListOf(Fruit("Apple", R.drawable.apple), Fruit("Banana",
        R.drawable.banana), Fruit("Orange", R.drawable.orange), Fruit("Watermelon",
        R.drawable.watermelon), Fruit("Pear", R.drawable.pear), Fruit("Grape",
        R.drawable.grape), Fruit("Pineapple", R.drawable.pineapple), Fruit("Strawberry",
        R.drawable.strawberry), Fruit("Cherry", R.drawable.cherry), Fruit("Mango",
        R.drawable.mango))

    val fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Deta deleted", Snackbar.LENGTH_SHORT)
                .setAction("Undo") {
                    Toast.makeText(this, "Data restored", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        //将Call菜单项设置成默认选中
        binding.navView.setCheckedItem(R.id.navCall)
        //设置一个菜单项选中事件的监听器
        //当用户点击任意菜单项后，就会回调到传入的Lambda表达式
        //可以在这里编写具体的逻辑处理
        binding.navView.setNavigationItemSelectedListener {
            //closeDrawers()方法可以将滑动菜单关闭
            binding.drawerLayout.closeDrawers()
            //返回true表示事件被处理
            true
        }
        initFruits()
        val layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(this, fruitList)
        binding.recyclerView.adapter = adapter

        binding.swipeRefresh.setColorSchemeResources(R.color.colorPrimary)
        binding.swipeRefresh.setOnRefreshListener {
            refreshFruit(adapter)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun refreshFruit(adapter: FruitAdapter) {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                initFruits()
                adapter.notifyDataSetChanged()
                binding.swipeRefresh.isRefreshing = false
            }
        }
    }

    private fun initFruits() {
        fruitList.clear()
        repeat(50) {
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> binding.drawerLayout.openDrawer(GravityCompat.START)
            R.id.backup -> Toast.makeText(this, "You clicked Backup",
                Toast.LENGTH_SHORT).show()
                    R.id.delete -> Toast.makeText(this, "You clicked Delete",
                Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this, "You clicked Settings",
                Toast.LENGTH_SHORT).show()
        }
        return true
    }

}
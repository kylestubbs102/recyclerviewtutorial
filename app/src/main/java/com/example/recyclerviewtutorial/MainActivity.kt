package com.example.recyclerviewtutorial

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // need lateinit if global variable doesn't have initial value
    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button

    private lateinit var adapter: RecyclerViewAdapter

    private lateinit var adapterList: MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        button = findViewById(R.id.button)

        adapterList = mutableListOf()

        adapter = RecyclerViewAdapter(adapterList)

        /*
         * This basically means recyclerview.adapter = ..., recyclerview.layoutManager = ...
         */
        recyclerView.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        setupButtonClick()
    }

    // Basically, add value to mutablelist, making sure the adapter doesn't lose it's reference,
    // so you can't create a new list. Then, notify the adapter that the data set changed to update
    // the view.
    private fun setupButtonClick() {
        button.setOnClickListener {
            adapterList.add(adapterList.size)
            adapter.notifyDataSetChanged()
        }
    }
}
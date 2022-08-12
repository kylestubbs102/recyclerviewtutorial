package com.example.recyclerviewtutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button

    private lateinit var adapter: RecyclerViewAdapter

    private lateinit var adapterList: MutableList<Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        button = view.findViewById(R.id.button)

        adapterList = mutableListOf()

        adapter = RecyclerViewAdapter(adapterList, ::goToFragment)

        /*
         * This basically means recyclerview.adapter = ..., recyclerview.layoutManager = ...
         */
        recyclerView.apply {
            adapter = this@ListFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }

        setupButtonClick()

        return view
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

    // we pass the function as a prop into the adapter
    private fun goToFragment(rowClicked: Int) {
        val fragment = ClickedFragment.newInstance(rowClicked)

        requireActivity().supportFragmentManager.commit {
            replace(R.id.fragment_container_view, fragment)
            addToBackStack(null)
        }
    }
}
package com.example.recyclerviewtutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*
 * Passes in list of data to be displayed, I usually pass in list of objects because
 * usually more data needs to be displayed
 */
class RecyclerViewAdapter(
    private val list: List<Int>,
    private val onClick: (Int) -> Unit,    // Constructors are like this, make it a val and you can use it
) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // creates the item to display in list, uses the recycler_view_item layout that I created
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textView.text = "Row ${list[position]}"

        holder.itemView.setOnClickListener {
            onClick(list[position])
        }
    }

    override fun getItemCount(): Int = list.size


    inner class ItemViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.recycler_view_item_text_view)
        }
    }

}
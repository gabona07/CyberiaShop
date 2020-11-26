package com.codecool.cyberiashop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codecool.cyberiashop.R
import kotlinx.android.synthetic.main.categories_row.view.*

class CategoriesAdapter(val categories: List<String>): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val categoryName = view.category
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        holder.categoryName.text = categories[position]
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}
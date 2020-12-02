package com.codecool.cyberiashop.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codecool.cyberiashop.R
import com.codecool.cyberiashop.model.Product
import com.codecool.cyberiashop.view.DetailsActivity
import com.squareup.picasso.Picasso

class ProductAdapter(private var products: MutableList<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>(), Filterable {

    var onItemClick: ((Product) -> Unit)? = null
    var productListFull = products.toMutableList()
    private val filter: Filter = (object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            var filteredList = mutableListOf<Product>()
            if (constraint == null || constraint.isEmpty()) {
                filteredList.addAll(productListFull)
            } else {
                val filterPattern = constraint.toString().toLowerCase().trim()
                productListFull.forEach {
                    if (it.title.toLowerCase().contains(filterPattern)) {
                        filteredList.add(it)
                    }
                }
            }
            val result = FilterResults()
            result.values = filteredList
            return result
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            products.clear()
            if (results != null) {
                setProducts(results.values as MutableList<Product>)
            }
            notifyDataSetChanged()
        }

    })

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.product_image)
        val title: TextView = itemView.findViewById(R.id.title)
        val price: TextView = itemView.findViewById(R.id.price)
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(products[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        val holder = ViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context, DetailsActivity::class.java)
            println("Position: ${holder.layoutPosition}")
            intent.putExtra("name", products[holder.adapterPosition].title)
            intent.putExtra("price", products[holder.adapterPosition].price)
            intent.putExtra("image", products[holder.adapterPosition].photoURL)
            parent.context.startActivity(intent)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(products[position].photoURL).into(holder.image)
        holder.title.text = products[position].title
        holder.price.text = products[position].price
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun getFilter(): Filter {
        return filter
    }

    fun setProducts(filteredProducts: MutableList<Product>) {
        this.products = filteredProducts
    }
}
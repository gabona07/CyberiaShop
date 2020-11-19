package com.codecool.cyberiashop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.codecool.cyberiashop.model.Product
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var products = ArrayList<Product>()
        for (i in 0..10) {
            products.add(Product("Apple", "https://via.placeholder.com/200x200", 1.99))
        }

        recycler_view.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = ProductAdapter(products)
        }
    }
}
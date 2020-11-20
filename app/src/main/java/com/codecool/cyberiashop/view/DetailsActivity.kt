package com.codecool.cyberiashop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.codecool.cyberiashop.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setProductDetails()

    }

    private fun setProductDetails() {
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val image = intent.getStringExtra("image")

        Picasso.get().load(image).into(detail_product_image)
        detail_product_name.text = name
        detail_product_price.text = price

        in_stock.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("It's in stock")
                .setPositiveButton("Ok") { p0, p1 -> return@setPositiveButton}
                .create()
                .show()
        }
    }
}
package com.codecool.cyberiashop.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codecool.cyberiashop.R
import com.codecool.cyberiashop.adapter.CategoriesAdapter
import com.codecool.cyberiashop.adapter.ProductAdapter
import com.codecool.cyberiashop.contract.MainContract
import com.codecool.cyberiashop.presenter.MainPresenter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment(),  MainContract.MainView {

    var presenter: MainPresenter = MainPresenter()
    var root : View? = null
    var recyclerView: RecyclerView? = null
    var categoriesRecyclerview: RecyclerView? = null
    var progressBar: ProgressBar? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter.onAttach(this)
        root = inflater.inflate(R.layout.fragment_main, container, false)
        progressBar = root!!.findViewById(R.id.progressBar)
        recyclerView = root!!.findViewById(R.id.recycler_view)
        categoriesRecyclerview = root!!.findViewById(R.id.categories_recycler_view)
        setupRecyclerView()
        progressBar!!.visibility = View.GONE
        return root
    }

    private fun setupRecyclerView() {
        recyclerView!!.layoutManager = GridLayoutManager(activity, 2)
        val adapter = ProductAdapter(presenter.databaseInit())
        recyclerView!!.adapter = adapter
        adapter.onItemClick= {
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("name", it.title)
            intent.putExtra("price", it.price)
            intent.putExtra("detail", it.details)
            intent.putExtra("image", it.photoURL)
            startActivity(intent)
        }
        val categories = listOf("Cyberware", "Clothing", "Electric Animals")
        categoriesRecyclerview!!.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        categoriesRecyclerview!!.adapter = CategoriesAdapter(categories)

    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun onError() {
        TODO("Not yet implemented")
    }
}
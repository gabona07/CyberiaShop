package com.codecool.cyberiashop.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codecool.cyberiashop.R
import com.codecool.cyberiashop.adapter.ProductAdapter
import com.codecool.cyberiashop.contract.MainContract
import com.codecool.cyberiashop.presenter.MainPresenter

class FragmentAnimals : Fragment(), MainContract.MainView {

    var presenter: MainPresenter = MainPresenter()
    var root : View? = null
    var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter.onAttach(this)
        root = inflater.inflate(R.layout.fragment_animals, container, false)
        recyclerView = root!!.findViewById(R.id.recycler_view_animals)
        setupRecyclerView()
        return root
    }

    private fun setupRecyclerView() {
        recyclerView!!.layoutManager = GridLayoutManager(activity, 2)
        presenter.databaseInit()
        val adapter = ProductAdapter(presenter.getAnimalItems())
        recyclerView!!.adapter = adapter
        adapter.onItemClick= {
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("name", it.title)
            intent.putExtra("price", it.price)
            intent.putExtra("detail", it.details)
            intent.putExtra("image", it.photoURL)
            startActivity(intent)
        }
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
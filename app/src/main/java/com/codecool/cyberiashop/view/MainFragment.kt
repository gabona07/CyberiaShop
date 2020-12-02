package com.codecool.cyberiashop.view

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ProgressBar
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codecool.cyberiashop.R
import com.codecool.cyberiashop.adapter.ProductAdapter
import com.codecool.cyberiashop.contract.MainContract
import com.codecool.cyberiashop.presenter.MainPresenter

class MainFragment: Fragment(),  MainContract.MainView {

    var presenter: MainPresenter = MainPresenter()
    var root : View? = null
    var recyclerView: RecyclerView? = null
    var progressBar: ProgressBar? = null
    var adapter: ProductAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter.onAttach(this)
        root = inflater.inflate(R.layout.fragment_main, container, false)
        progressBar = root!!.findViewById(R.id.progressBar)
        recyclerView = root!!.findViewById(R.id.recycler_view)
        setupRecyclerView()
        progressBar!!.visibility = View.GONE
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val item = menu.findItem(R.id.search_action)
        val searchView : SearchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter!!.filter.filter(newText)
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
    }
    private fun setupRecyclerView() {
        recyclerView!!.layoutManager = GridLayoutManager(activity, 2)
        adapter = ProductAdapter(presenter.databaseInit())
        recyclerView!!.adapter = adapter
        adapter!!.onItemClick= {
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
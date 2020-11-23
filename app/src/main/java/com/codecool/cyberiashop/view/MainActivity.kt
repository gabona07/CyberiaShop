package com.codecool.cyberiashop.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.codecool.cyberiashop.FragmentAnimals
import com.codecool.cyberiashop.MainFragment
import com.codecool.cyberiashop.adapter.ProductAdapter
import com.codecool.cyberiashop.R
import com.codecool.cyberiashop.contract.MainContract
import com.codecool.cyberiashop.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigationView()
        setupActionBar()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, MainFragment()).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawer_layout.openDrawer(GravityCompat.START)
        return super.onOptionsItemSelected(item)
    }

    private fun setupActionBar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
        }
    }

    private fun setupNavigationView() {
        nav_view.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, MainFragment()).commit()
                }
                R.id.cyberware -> println()
                R.id.clothing -> println()
                R.id.electric_animals -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, FragmentAnimals()).commit()
                }
            }
            it.isChecked = true
            drawer_layout.closeDrawers()
            true
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
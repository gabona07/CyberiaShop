package com.codecool.cyberiashop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.codecool.cyberiashop.R
import com.codecool.cyberiashop.contract.MainContract
import kotlinx.android.synthetic.main.activity_main.*

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
                R.id.cyberware -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, FragmentCyberware()).commit()
                }
                R.id.clothing -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, FragmentClothing()).commit()
                }
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
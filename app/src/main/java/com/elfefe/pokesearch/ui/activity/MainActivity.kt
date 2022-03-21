package com.elfefe.pokesearch.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.elfefe.pokesearch.R
import com.elfefe.pokesearch.ui.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar_main))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        openFragment(MainFragment.newInstance())
    }

    fun openFragment(fragment: Fragment) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_main_container, fragment)
                .commitNow()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        openFragment(MainFragment.newInstance())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
         when (item.itemId) {
             android.R.id.home -> {
                 onBackPressed()
                 true
             }
            else -> super.onOptionsItemSelected(item)
        }
}
package com.example.homework_017drawer

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_017drawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val stuffList =
        mutableListOf<Stuff>(Stuff("test name 1", 23, R.drawable.ic_baseline_dashboard_24),
            Stuff("test name 2", 99, R.drawable.ic_baseline_dashboard_24),
            Stuff("test name 3", drawable= R.drawable.ic_baseline_dashboard_24),
            Stuff("test name 4", 83, R.drawable.ic_baseline_dashboard_24),
            Stuff("test name 5", drawable= R.drawable.ic_baseline_dashboard_24)


        )

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: StuffRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        setSupportActionBar(binding.appBarMain.toolbar) //
        this.supportActionBar?.hide()






        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        setRecycler()

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setRecycler() {

        adapter = StuffRecycler()
        adapter.list = stuffList
        adapter.notifyDataSetChanged()
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter


    }
}
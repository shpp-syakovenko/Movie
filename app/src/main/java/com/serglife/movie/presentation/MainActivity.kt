package com.serglife.movie.presentation


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.serglife.movie.R
import com.serglife.movie.data.database.AUTH
import com.serglife.movie.data.database.REF_DATABASE_ROOT
import com.serglife.movie.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFields()
        initToolBar()
    }

    private fun initToolBar() {
        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.mainToolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun initFields() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        AUTH = Firebase.auth
        REF_DATABASE_ROOT = Firebase.database.reference
        setContentView(binding.root)
        val host = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = host.navController
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> {
                navController.navigate(R.id.moviesFragment)
            }
            R.id.favorites -> {
                navController.navigate(R.id.favoritesFragment)
            }
            R.id.log_in -> {
                navController.navigate(R.id.inLoginFragment)
            }
            R.id.log_out -> {
                AUTH.signOut()
                navController.navigate(R.id.moviesFragment)
                Toast.makeText(this,"You are logged out.", Toast.LENGTH_SHORT).show()
            }
            R.id.current_token -> {
                Toast.makeText(this,"${AUTH.currentUser?.uid}", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

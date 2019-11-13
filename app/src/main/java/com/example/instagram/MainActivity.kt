package com.example.instagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.instagram.navigation.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    private val onNavigationItemSelectedListener=BottomNavigationView.OnNavigationItemSelectedListener {item->
        when(item.itemId){

            R.id.action_home -> {
                moveToFragment(homeFragment())
                return@OnNavigationItemSelectedListener true


            }
            R.id.action_search -> {
                moveToFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true

            }
            R.id.action_add_photo -> {
                moveToFragment(AddPhotoFragment())
                return@OnNavigationItemSelectedListener true

            }
            R.id.action_activity-> { moveToFragment(ActivityFragment())
                return@OnNavigationItemSelectedListener true

            }
            R.id.action_account -> { moveToFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true

            }
        }

        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        moveToFragment(homeFragment())





    }
    private fun moveToFragment(fragment:Fragment){
        val fragmentTrans=supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container,fragment).commit()

    }



}



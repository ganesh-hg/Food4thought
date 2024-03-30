package com.example.food4thought

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.example.food4thought.databinding.ActivityHoteldashBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.math.log

class hoteldash : AppCompatActivity() {


    private lateinit var binding: ActivityHoteldashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoteldash)

        val bottom = findViewById<BottomNavigationView>(R.id.bottom)

        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {


                R.id.shop ->
                {
                   // Toast.makeText(applicationContext,"Recipe",Toast.LENGTH_LONG).show()

                    val i = Intent(applicationContext,AddUserFood::class.java)
                    startActivity(i)
                    true

                }


                R.id.feedback ->
                {

                    //Toast.makeText(applicationContext,"food nutrition",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext,ShowHotelfeedback::class.java)
                    startActivity(i)
                    true
                }
                R.id.showre ->
                {

                    //Toast.makeText(applicationContext,"Upload Video",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext,Hotelhistory::class.java)
                    startActivity(i)
                    true
                }
                R.id.ngo ->
                {

                    //Toast.makeText(applicationContext,"Upload Video",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext,Ngofeedback::class.java)
                    startActivity(i)
                    true
                }
                R.id.profile ->
                {

                    //Toast.makeText(applicationContext,"Product nutrition",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext,MainActivity::class.java)
                    startActivity(i)
                    true
                }



                else -> {false}
            }
        }


    }
}
package com.example.food4thought

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import java.util.Locale

class Feedback : AppCompatActivity() {

    var sharedpreferences: SharedPreferences? = null

    var chapati:String?=null
    var dal:String?=null
    var sabji:String?=null
    var address:String?=null
    var time:String?=null
    var name:String?=null
    var feed:String?=null
    var hotelname:String?=null

    var email:String?=null
    var image: ImageView?=null



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        val edaddress = findViewById<EditText>(R.id.edaddress)
        val edexpiry = findViewById<EditText>(R.id.edfeed)
        val hname = findViewById<EditText>(R.id.edname)

        val btn = findViewById<Button>(R.id.btnsubmit)

        val bundle = intent.extras
        val honame = bundle?.getString("name")



        btn.setOnClickListener {



            address = edaddress.text.toString()
            feed=edexpiry.text.toString()

            hotelname=hname.text.toString()



            val data = FirebaseDatabase.getInstance().reference.child("hotelfeedback")
            val feedback = Hotelfeed(hotelname,address,feed,honame)
            data.push().setValue(feedback)

            Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()


        }

    }
}
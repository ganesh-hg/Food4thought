package com.example.food4thought

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class Ngofeedback : AppCompatActivity() {

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
        setContentView(R.layout.activity_ngofeedback)

        val edaddress = findViewById<EditText>(R.id.edaddress)
        val edexpiry = findViewById<EditText>(R.id.edfeed)
        val hname = findViewById<EditText>(R.id.edname)

        val btn = findViewById<Button>(R.id.btnsubmit)
        val pref = getSharedPreferences("Ngo", MODE_PRIVATE)
        val name = pref.getString("name", "")
        val add = pref.getString("add", "")
        Toast.makeText(applicationContext,name.toString(), Toast.LENGTH_LONG).show()


        btn.setOnClickListener {



            address = edaddress.text.toString()
            feed=edexpiry.text.toString()

            hotelname=hname.text.toString()



            val data = FirebaseDatabase.getInstance().reference.child("ngofeedback")
            val feedback = Ngofeed(hotelname,address,feed,name,add)
            data.push().setValue(feedback)

            Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()


        }
    }
}
package com.example.food4thought

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class Ngosendsms : AppCompatActivity() {

    var sharedpreferences: SharedPreferences? = null

    var chapati:String?=null
    var dal:String?=null
    var sabji:String?=null
    var address:String?=null
    var time:String?=null
    var name:String?=null
    var feed:String?=null
    var ngoname:String?=null

    var email:String?=null
    var image: ImageView?=null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ngosendsms)

        val edaddress = findViewById<EditText>(R.id.edaddress)

        val hname = findViewById<EditText>(R.id.edname)

        val btn = findViewById<Button>(R.id.btnsubmit)

        val bundle = intent.extras
        val honame = bundle?.getString("name")
        val number = bundle?.getString("number")

        btn.setOnClickListener {



            address = edaddress.text.toString()


            ngoname=hname.text.toString()



            val data = FirebaseDatabase.getInstance().reference.child("ngodetails")
            val feedback = Ngooder(ngoname,address,honame,number)
            data.push().setValue(feedback)

            Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()

            val smsManager = SmsManager.getDefault() as SmsManager
            smsManager.sendTextMessage("+91$number",null,"We Need Food",null,null)


        }




    }
}
package com.example.food4thought

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class productdetails : AppCompatActivity() {

    var name: String? = null
    var material: String? = null
    var manifacute: String? = null
    var origin: String? = null
    var weight: String? = null
    var rating: String? = null
    var demi: String? = null
    var number: String? = null

    var ref: DatabaseReference? = null
    var username: String? = null
    var usermobile: String? = null
    var useremail: String? = null
    var useraddress: String? = null
    var url: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productdetails)

        val txtproname = findViewById<TextView>(R.id.txtname)
        val txtmaterial = findViewById<TextView>(R.id.txtmaterial)
        val txtaddress = findViewById<TextView>(R.id.txtmanifacture)

        val txtarea = findViewById<TextView>(R.id.txtorigin)
        val txtwight = findViewById<TextView>(R.id.txtweigth)
        val txtrating = findViewById<TextView>(R.id.txtrating)
        val txtnumber = findViewById<TextView>(R.id.txtnumber)



        val bundle = intent.extras

        name = bundle?.getString("name")
        material = bundle?.getString("sabji")
        manifacute = bundle?.getString("dal")
        origin = bundle?.getString("address")
        weight = bundle?.getString("chpati")
        rating = bundle?.getString("time")
        number = bundle?.getString("number")


        txtproname.setText("Hotel Name:" + name)
        txtmaterial.setText("Sabhji in kg: " + material)
        txtaddress.setText("Dal in kg: " + manifacute)
        txtarea.setText("Address: " + origin)
        txtwight.setText("Chapati: " + weight)
        txtrating.setText("Time: " + rating)
        txtnumber.setText("Number: " + number)
        val btnorder = findViewById<Button>(R.id.btnorder)
        btnorder.setOnClickListener {

            Toast.makeText(applicationContext,"place order",Toast.LENGTH_LONG).show()
            val mDatabaseRef = FirebaseDatabase.getInstance().getReference("UserFood").orderByChild("hotelname").equalTo(name)
            mDatabaseRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
//                println(snapshot)
                    for(obj in snapshot.children)
                    {
//                   println(obj)
                        println(obj.key)

                        val key = obj.key

                        val databaseReference = FirebaseDatabase.getInstance().getReference("UserFood").child(key!!)
                        databaseReference.child("status").setValue("Deactive")
                        databaseReference.child("hotelname").setValue(name)
                        databaseReference.child("chapati").setValue(weight)
                        databaseReference.child("dal").setValue(manifacute)
                        databaseReference.child("sabji").setValue(material)
                        databaseReference.child("address").setValue(origin)
                        databaseReference.child("time").setValue(rating)
                        databaseReference.child("number").setValue(number)

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }


        val btntrack = findViewById<Button>(R.id.btntrack)

        btntrack.setOnClickListener {
            try {
                val uri = Uri.parse("https://www.google.co.in/maps/dir/"+"/"+ origin)

                val intent = Intent(Intent.ACTION_VIEW,uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }catch (e: ActivityNotFoundException)
            {
                val uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

        }


        val btnfeed = findViewById<Button>(R.id.btnfeedback)

        btnfeed.setOnClickListener {
            val intent = Intent(applicationContext,Feedback::class.java)
            intent.putExtra("name",name)

            startActivity(intent)
        }

        val btnsend = findViewById<Button>(R.id.btnsend)
        btnsend.setOnClickListener {
//            val intent = Intent(applicationContext,Ngosendsms::class.java)
//            intent.putExtra("name",name)
//            intent.putExtra("number",number)
//
//            startActivity(intent)
            val smsManager: SmsManager = SmsManager.getDefault()

            smsManager.sendTextMessage(number, null, "We need Food", null, null)
        }



    }
}
package com.example.food4thought

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class register : AppCompatActivity() {


    lateinit var auth: FirebaseAuth

    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    var name:EditText?=null
    var address:EditText?=null
    var number:EditText?=null
    var email:EditText?=null
    var password:EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

         name = findViewById<EditText>(R.id.student_name)

         number = findViewById<EditText>(R.id.student_monumber)
         email = findViewById<EditText>(R.id.student_email)
         password = findViewById<EditText>(R.id.student_password)
        val btn = findViewById<Button>(R.id.btnregister)
        val txt = findViewById<TextView>(R.id.txtlogin)



        txt.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Hotel")



        btn.setOnClickListener {
            if(name!!.text.isEmpty())
            {
                name!!.setError("Enter name")
                return@setOnClickListener
            }else if(password!!.text.isEmpty())
            {
                password!!.setError("Enter Password ")
                return@setOnClickListener
            }else if(number!!.text.isEmpty())
            {
                number!!.setError("Enter Contact Number")
                return@setOnClickListener
            }else if(email!!.text.isEmpty())
            {
                email!!.setError("Enter Email id")
                return@setOnClickListener
            }


            auth.createUserWithEmailAndPassword(email!!.text.toString(), password!!.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        val currentuser = auth.currentUser
                        val currentUserdb = databaseReference?.child((currentuser?.uid!!))
                        currentUserdb?.child("name")?.setValue(name!!.text.toString())


                        currentUserdb?.child("number")?.setValue(number!!.text.toString())

                        Toast.makeText(applicationContext,"success", Toast.LENGTH_LONG).show()
//                        Toast.makeText(applicationContext,adhar.text.toString(), Toast.LENGTH_LONG).show()


                    }
                    else
                    {
                        Toast.makeText(applicationContext,"failed", Toast.LENGTH_LONG).show()
                    }
                }


            sharedata(name!!.text.toString(),email!!.text.toString(),number!!.text.toString())
            cleardata()
        }

    }

    private fun cleardata() {

        name!!.setText("")
//        address!!.setText("")
        number!!.setText("")
        email!!.setText("")
        password!!.setText("")
    }
    private fun sharedata(value: String, email: String, number: String) {
        val sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)
        val editor = sharedpreferences!!.edit()

        editor.putString("name", value)
        editor.putString("number",number)
        editor.putString("mail",email)

        editor.commit()
        editor.apply()
    }

}
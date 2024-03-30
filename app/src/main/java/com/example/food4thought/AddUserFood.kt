package com.example.food4thought

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.location.Geocoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.google.firebase.database.FirebaseDatabase
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.util.*

class AddUserFood : AppCompatActivity() {

    var sharedpreferences: SharedPreferences? = null

    var chapati:String?=null
    var dal:String?=null
    var sabji:String?=null
    var conaddress:String?=null
    var time:String?=null
    var name:String?=null
    var monumber:String?=null
    var hotelname:String?=null

    var email:String?=null
    var image:ImageView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user_food)


        sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)

        email = sharedpreferences!!.getString("email","default")

        Toast.makeText(applicationContext,email, Toast.LENGTH_LONG).show()


        val edchapati = findViewById<EditText>(R.id.edchapati)
        val eddal = findViewById<EditText>(R.id.eddal)
        val edbhaji = findViewById<EditText>(R.id.edsabji)
        val edaddress = findViewById<EditText>(R.id.edaddress)
        val edexpiry = findViewById<EditText>(R.id.edtime)
        val hname = findViewById<EditText>(R.id.edname)
        val number = findViewById<EditText>(R.id.ednumber)
         image = findViewById<ImageView>(R.id.imageView4)


        val btn = findViewById<Button>(R.id.btnsubmit)

        btn.setOnClickListener {

            chapati = edchapati.text.toString()
            dal = eddal.text.toString()
            sabji = edbhaji.text.toString()

            conaddress = edaddress.text.toString()
            time=edexpiry.text.toString()

            hotelname=hname.text.toString()

            monumber = number.text.toString()

            val geocode = Geocoder(this, Locale.getDefault())

            val addlist = geocode.getFromLocationName(conaddress,1)
            val lat = addlist[0].latitude.toString()
            val lng = addlist[0].longitude.toString()


            val data = FirebaseDatabase.getInstance().reference.child("UserFood")
            val user = Userfood(hotelname,chapati,dal,sabji,conaddress,time,"Active",monumber)
            data.push().setValue(user)
            sharedata(conaddress!!)
            Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()
            sendnotify(hotelname!!,chapati!!,dal!!,sabji!!,time!!,"activate")


        }

    }

    private fun sendnotify(hotelname: String, chapati: String, dal: String, sabji: String, time: String, status: String) {
        val sb = StringBuffer()
        sb.append("Hotel name ").append(hotelname)
        sb.append(System.getProperty("line.separator"))

        sb.append(System.getProperty("line.separator"))
        sb.append("Chapati ").append(chapati)
        sb.append(System.getProperty("line.separator"))
        sb.append("Dal ").append(dal)

        sb.append(System.getProperty("line.separator"))

        sb.append(System.getProperty("line.separator"))
        sb.append("Sabhaji ").append(sabji)
        sb.append(System.getProperty("line.separator"))
        sb.append("time ").append(time)
        sb.append(System.getProperty("line.separator"))
        sb.append("status ").append(status)
        sb.append(System.getProperty("line.separator"))
        sb.append("Number ").append(monumber)

        val msg =sb.toString()

        val writer = QRCodeWriter()
        try{
            val bitMatrix = writer.encode(msg, BarcodeFormat.QR_CODE,512,512)
            val width = bitMatrix.width
            val height = bitMatrix.height
            val bmp= Bitmap.createBitmap(width,height,Bitmap.Config.RGB_565)
            for(x in 0 until width){
                for(y in 0 until height)
                {
                    bmp.setPixel(x,y, if(bitMatrix[x,y]) Color.BLACK else Color.WHITE)

                }
            }
            image!!.setImageBitmap(bmp)
            createImageFile(bmp)




        }catch (e: Exception)
        {
            e.printStackTrace()
        }

    }

    private fun createImageFile(bmp: Bitmap?) {
        if (Build.VERSION.SDK_INT >= 30) {
            if (!Environment.isExternalStorageManager()) {
                val getpermission = Intent()
                getpermission.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
                startActivity(getpermission)
            }
        }

        val bytes = ByteArrayOutputStream()
        bmp!!.compress(Bitmap.CompressFormat.JPEG,40,bytes)
        val filepath = Environment.getExternalStorageDirectory().absolutePath + File.separator + "test.jpeg"

        try {
            val f = File(filepath)
            f.createNewFile()
            val fo = FileOutputStream(f)
            fo.write(bytes.toByteArray())
            fo.close()
        }catch (e:Exception)
        {
            e.printStackTrace()
        }


    }


    private fun sharedata(conaddress: String) {
        sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)
        val editor = sharedpreferences!!.edit()

        editor.putString("address", conaddress)

        editor.commit()
        editor.apply()

    }
}
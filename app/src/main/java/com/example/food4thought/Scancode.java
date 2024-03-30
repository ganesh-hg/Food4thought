package com.example.food4thought;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class Scancode extends AppCompatActivity {

    Button btnscan;
    String mail,key;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scancode);
        btnscan = findViewById(R.id.button2);
        sharedPreferences = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        key = sharedPreferences.getString("key", "");
        // Toast.makeText(getApplicationContext(),key,Toast.LENGTH_LONG).show();


        btnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScanCode();

            }
        });
    }


    private void ScanCode() {

        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLaucher.launch(options);
    }

    ActivityResultLauncher<ScanOptions> barLaucher = registerForActivityResult(new ScanContract(), result -> {


        if(result.getContents() !=null)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("result");
            builder.setMessage(result.getContents());

            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

//                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("data").child(key);
//                    databaseReference.child("status").setValue("expiry");
//                    Toast.makeText(Scancode.this, "Updated", Toast.LENGTH_SHORT).show();

                }
            }).show();
        }
    });
}
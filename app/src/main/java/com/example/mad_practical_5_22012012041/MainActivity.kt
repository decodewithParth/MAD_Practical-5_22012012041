package com.example.mad_practical_5_22012012041

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val browseButton:Button =findViewById<Button>(R.id.browse);
        val s:EditText=findViewById<EditText>(R.id.editTextText);
        browseButton.setOnClickListener { openUrl(s.text.toString()) }
    }

    fun openUrl(url:String){
         Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) };
    }

    fun dialPhone(number:String){

    }

    fun callLog(){

    }

    fun openGallery(){

    }

    fun openCamera(){

    }

    fun setAlarm(){

    }

}
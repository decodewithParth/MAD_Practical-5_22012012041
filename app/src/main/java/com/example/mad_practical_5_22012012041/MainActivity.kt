package com.example.mad_practical_5_22012012041

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val browseButton:Button =findViewById<Button>(R.id.browse);
        val s:EditText=findViewById<EditText>(R.id.editTextText);
        browseButton.setOnClickListener { openUrl(s.text.toString()) }

        val dial:Button=findViewById<Button>(R.id.dial);
        val no:EditText=findViewById<EditText>(R.id.editTextPhone);
        dial.setOnClickListener { dialPhone((no.text.toString())) };

        val cL:Button=findViewById<Button>(R.id.callLog);
        cL.setOnClickListener { callLog() };

        val g:Button=findViewById<Button>(R.id.gallery)
        g.setOnClickListener { openGallery() };

        val camera:Button=findViewById<Button>(R.id.camera);
        camera.setOnClickListener { openCamera() };

        val alarm:Button=findViewById<Button>(R.id.alarm);
        alarm.setOnClickListener { setAlarm() };
    }

    fun openUrl(url:String){
         Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) };
    }

    fun dialPhone(number:String){
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$number")).also { startActivity(it) }
    }

    fun callLog(){
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }

    fun openGallery(){
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }

    fun openCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }

    fun setAlarm(){
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }

}
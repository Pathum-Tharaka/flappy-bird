package com.example.myapplicationbird

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppConstants.initialization(context:this.getApplicationContext());
    }


    fun startGame(view: View) {
       // Log.i("ImageButton", "clicked")
        Intent intent = new Intent(packageContext:this,GameActivity.class);
        startActivity(intent);
        finish();
    }

}
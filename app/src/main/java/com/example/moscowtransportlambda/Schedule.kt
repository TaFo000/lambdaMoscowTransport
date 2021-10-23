package com.example.moscowtransportlambda

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class Schedule : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try{
            setContentView(R.layout.schedule)
        }catch(e:Exception){
            e.printStackTrace()
        }


        val param_btn = findViewById<ImageButton>(R.id.params)
        val route_btn = findViewById<ImageButton>(R.id.route)
        val back_btn = findViewById<Button>(R.id.back_btn)
        param_btn.setOnClickListener{
            var intent = Intent(this@Schedule,Params::class.java)
            startActivity(intent)
        }
        route_btn.setOnClickListener{
            var intent = Intent(this@Schedule,Route::class.java)
            startActivity(intent)
        }
        back_btn.setOnClickListener{
            this@Schedule.finish()
        }
    }
}
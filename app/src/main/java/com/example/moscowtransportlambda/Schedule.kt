package com.example.moscowtransportlambda

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.activity.ComponentActivity

class Schedule : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.schedule)
        val param_btn = findViewById<Button>(R.id.params)
        val route_btn = findViewById<Button>(R.id.route)
        val back_btn = findViewById<Button>(R.id.back_btn)
        param_btn.setOnClickListener{

        }
        route_btn.setOnClickListener{

        }
        back_btn.setOnClickListener{
            this@Schedule.finish()
        }
    }
}
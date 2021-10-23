package com.example.moscowtransportlambda

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class Layersss : ComponentActivity() {
    var c = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layers)
        var back = findViewById<ImageButton>(R.id.imageButton3)
        back.setOnClickListener{
            this@Layersss.finish()
        }
    }
}
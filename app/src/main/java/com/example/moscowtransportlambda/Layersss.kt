package com.example.moscowtransportlambda

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class Layersss : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.layerss)
        var btn = findViewById<ImageButton>(R.id.imageButton)
        btn.setOnClickListener{
            this@Layersss.finish()
        }
    }
}
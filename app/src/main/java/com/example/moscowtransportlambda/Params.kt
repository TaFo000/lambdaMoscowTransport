package com.example.moscowtransportlambda

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class Params: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.params_layout)
        var btn = findViewById<Button>(R.id.btttn)
        btn.setOnClickListener {
            this@Params.finish()
        }
    }
}
package com.example.moscowtransportlambda

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.activity.ComponentActivity

class OfferParking : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.offer)
        var btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            this@OfferParking.finish()
        }

    }
}
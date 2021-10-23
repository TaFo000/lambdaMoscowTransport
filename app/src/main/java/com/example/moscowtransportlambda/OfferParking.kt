package com.example.moscowtransportlambda

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity

class OfferParking : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.offer)
    }
}
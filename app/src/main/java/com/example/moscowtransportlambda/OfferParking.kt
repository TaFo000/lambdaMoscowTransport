package com.example.moscowtransportlambda

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity

class OfferParking : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try{
            setContentView(R.layout.offer)
        }
        catch (e:Exception){
            e.printStackTrace()
        }

    }
}
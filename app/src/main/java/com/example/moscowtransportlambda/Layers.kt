package com.example.moscowtransportlambda

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity

class Layers : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        try{
            setContentView(R.layout.layers)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}
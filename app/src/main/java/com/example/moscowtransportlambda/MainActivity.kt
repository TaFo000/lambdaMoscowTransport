package com.example.moscowtransportlambda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)
        var kuda = findViewById<Button>(R.id.kuda_btn)
        kuda.setOnClickListener {
            var intent = Intent(this@MainActivity,SwipeChoice::class.java)
            startActivity(intent)
        }
        var layerss = findViewById<Button>(R.id.layers_btn)
        layerss.setOnClickListener {
            var yintent = Intent(this@MainActivity,Layersss::class.java)
            try{
                startActivity(yintent)
            }
            catch(e:Exception){
                e.printStackTrace()
            }
        }

    }
}

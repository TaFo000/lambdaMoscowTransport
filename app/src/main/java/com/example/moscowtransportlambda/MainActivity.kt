package com.example.moscowtransportlambda

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.moscowtransportlambda.ui.theme.MoscowTransportlambdaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)
        var kuda = findViewById<Button>(R.id.kuda_btn)
        kuda.setOnClickListener {
            var intent = Intent(this@MainActivity,SwipeChoice::class.java)
            startActivity(intent)
        }
        var layerss = findViewById<Button>(R.id.kuda_btn2)
        layerss.setOnLongClickListener {
            var intent = Intent(this@MainActivity,Layers::class.java)
            startActivity(intent)
        }

    }
}

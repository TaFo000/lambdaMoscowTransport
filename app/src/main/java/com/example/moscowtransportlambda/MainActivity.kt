package com.example.moscowtransportlambda

import android.os.Bundle
import android.util.Log
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
import com.example.moscowtransportlambda.ui.theme.MoscowTransportlambdaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        var im = findViewById<ImageView>(R.id.imageView)
        im.setOnTouchListener(object : OnSwipeListener(this@MainActivity) {
            override fun onSwipeLeftToRight() {
                Log.d("aa","right")
            }
            override fun onSwipeRightToLeft() {
                Log.d("aa","left")
            }
            override fun onSwipeBottomToTop() {
                Log.d("aa","top")
            }
            override fun onSwipeTopToBottom() {
                Log.d("aa","bottom")
            }
        })

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",
    modifier = Modifier.clickable {

    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoscowTransportlambdaTheme {
        Greeting("Android")
    }
}
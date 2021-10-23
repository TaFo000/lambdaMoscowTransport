package com.example.moscowtransportlambda

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.widget.AbsoluteLayout
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat.setX
import androidx.core.view.ViewCompat.setY
import java.lang.Float.max

class Route  : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.route_layout)
        
        var bot = findViewById<ImageView>(R.id.imageView11)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        setY(bot,height.toFloat())
        var btn = findViewById<Button>(R.id.bttn)
        btn.setOnClickListener {
            this@Route.finish()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val y = event.y.toInt()
        var bot = findViewById<ImageView>(R.id.imageView11)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                if(y <= height-bot.height){
                    setY(bot,(height-bot.height).toFloat())
                }else{
                    setY(bot,y.toFloat())
                }
            }
            MotionEvent.ACTION_UP -> {
                if(y <= height - bot.height){
                    setY(bot,(height-bot.height).toFloat())
                }else{
                    setY(bot,height.toFloat())
                }
            }
        }
        return false
    }
}
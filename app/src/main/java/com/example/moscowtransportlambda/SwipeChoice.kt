package com.example.moscowtransportlambda

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.media.Image
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat.*
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.ImageView
import androidx.compose.ui.graphics.Color
import java.lang.Math.*


class SwipeChoice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.swipe_choice)
        var btn = findViewById<ImageButton>(R.id.imageButton2)
        btn.setOnClickListener{
            this@SwipeChoice.finish()
        }
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val y = event.y.toInt()
        val angle = get_angle(x.toDouble(),y.toDouble())
        when (event.action) {
            MotionEvent.ACTION_MOVE -> move(angle)
            MotionEvent.ACTION_UP -> check(angle)
        }
        return false
    }
    fun move(angle:Double){
        var e = findViewById<ConstraintLayout>(R.id.card).getChildAt(0)
        var c = Color(255,255,0,255)
        // to blue
        var new_angle = max(min(angle,30.0),-30.0) / 60.0 + 0.5
        Log.i("TAG",new_angle.toString())
        var color = 0xFF000000 + (0xFF*new_angle).toInt()*0x100 + (0xFF*(1-new_angle)).toInt()
        e.setBackgroundColor(color.toInt())

        var el = findViewById<ImageView>(R.id.image)
        setPivotX(el,el.width.toFloat()/2)
        setPivotY(el,el.height.toFloat()*2)
        setRotation(el,-angle.toFloat()/5)

        var el2 = findViewById<ImageView>(R.id.image2)
        setPivotX(el2,el2.width.toFloat()/2)
        setPivotY(el2,el2.height.toFloat()*2)
        setRotation(el2,-angle.toFloat()/5)
        el2.setAlpha(max(0.0,1-abs(new_angle-0.5)*4.0).toFloat())

        var el3 = findViewById<ImageView>(R.id.carar)
        setPivotX(el3,el3.width.toFloat()/2)
        setPivotY(el3,el3.height.toFloat()*2)
        setRotation(el3,-angle.toFloat()/5)
        el3.setAlpha(((max(new_angle,0.66)-0.66)*3).toFloat())

        var el4 = findViewById<ImageView>(R.id.autobusus)
        setPivotX(el4,el4.width.toFloat()/2)
        setPivotY(el4,el4.height.toFloat()*2)
        setRotation(el4,-angle.toFloat()/5)
        el4.setAlpha(((0.33 - (min(new_angle,0.33)))*3).toFloat())
    }
    fun check(angle:Double){
        var el = findViewById<ImageView>(R.id.image)
        var el2 = findViewById<ImageView>(R.id.image2)
        var el3 = findViewById<ImageView>(R.id.autobusus)
        var el4 = findViewById<ImageView>(R.id.carar)
        var e = findViewById<ConstraintLayout>(R.id.card).getChildAt(0)
        if(angle > 20.0f){
            intent = Intent(this@SwipeChoice,OfferParking::class.java)
            startActivity(intent)
        }
        else if(angle < -20.0f){
            intent = Intent(this@SwipeChoice,Schedule::class.java)
            startActivity(intent)
        }
        e.setBackgroundColor(0xFFBB0000.toInt())
        setRotation(el, 0f)
        setRotation(el2,0f)
        setRotation(el3,0f)
        setRotation(el4,0f)

    }
    fun get_angle(x:Double,y:Double) : Double{
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        return atan2(width/2.0f - x,height-y)*180/3.1416
    }
}
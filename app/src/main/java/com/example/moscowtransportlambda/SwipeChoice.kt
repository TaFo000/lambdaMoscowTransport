package com.example.moscowtransportlambda

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class SwipeChoice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.swipe_choice)
        var im = findViewById<ConstraintLayout>(R.id.card)
        im.setOnTouchListener(object : OnSwipeListener(this@SwipeChoice) {
            override fun onSwipeLeftToRight() {

                var anim = AnimationUtils.loadAnimation(this@SwipeChoice,R.anim.slide_right_anim)
                var el = findViewById<ConstraintLayout>(R.id.card)
                el.startAnimation(anim)
            }
            override fun onSwipeRightToLeft() {
                var anim = AnimationUtils.loadAnimation(this@SwipeChoice,R.anim.slide_left_anim)
                var el = findViewById<ConstraintLayout>(R.id.card)
                el.startAnimation(anim)
            }
        })
    }
}
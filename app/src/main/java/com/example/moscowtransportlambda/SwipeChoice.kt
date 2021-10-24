package com.example.moscowtransportlambda

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat.*
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.ImageView
import java.lang.Math.*


class SwipeChoice : ComponentActivity() {
    // Окно свайпа для выбора транспорта

    // Создание окна
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.swipe_choice) // Рендер макета расположения элементов интерфейса

        // обработчик нажатия на кнопку возвраения назад
        var btn = findViewById<ImageButton>(R.id.return_button)
        btn.setOnClickListener{
            this@SwipeChoice.finish() // Завершение текущего окна
        }
    }

    // Обработчик нажатий пользователя на экран
    override fun onTouchEvent(event: MotionEvent): Boolean {
        // получение координат нажатия
        val x = event.x.toInt()
        val y = event.y.toInt()
        val angle = get_angle(x.toDouble(),y.toDouble())

        // Обработчка нажатия
        when (event.action) {
            // Если человек продолжает нажимать на экран
            MotionEvent.ACTION_MOVE -> move(angle) // Повернуть карточки
            // Если человек перестал нажимать на экран
            MotionEvent.ACTION_UP -> check(angle) // проверить координаты его последнего нажатия
        }
        return false
    }

    // Перемешение карточек, angle - угол поворота
    fun move(angle:Double){
        var e = findViewById<ConstraintLayout>(R.id.card).getChildAt(0)

        // Обработка входных данных
        var new_angle = max(min(angle,30.0),-30.0) / 60.0 + 0.5 // Получение нового угла который при повороте с угла от -30 до 30 градусов пробегается линейно от 0 до 1
        var color = 0xFF000000 + (0xFF*new_angle).toInt()*0x100 + (0xFF*(1-new_angle)).toInt() // Линейный переход из одного цвета в другой в зависимости от угла
        e.setBackgroundColor(color.toInt())

        // Поворот белого заднего экрана
        var el = findViewById<ImageView>(R.id.image)
        setPivotX(el,el.width.toFloat()/2) // Установления точки поворота
        setPivotY(el,el.height.toFloat()*2)
        setRotation(el,-angle.toFloat()/5) // Осуществление поворота

        // Поворот смайлика
        var el2 = findViewById<ImageView>(R.id.image2)
        setPivotX(el2,el2.width.toFloat()/2) // Установление точки поворота
        setPivotY(el2,el2.height.toFloat()*2)
        setRotation(el2,-angle.toFloat()/5) // Осуществление поворота
        el2.setAlpha(max(0.0,1-abs(new_angle-0.5)*4.0).toFloat()) // Установление прозрачности в зависимости от угла

        // Поворот машины
        var el3 = findViewById<ImageView>(R.id.carar)
        setPivotX(el3,el3.width.toFloat()/2) // Установление точки поворота
        setPivotY(el3,el3.height.toFloat()*2)
        setRotation(el3,-angle.toFloat()/5) // Осуществление поворота
        el3.setAlpha(((max(new_angle,0.66)-0.66)*3).toFloat()) // Установление прощрачности линейно в зависимости от угла

        // Поворот автобуса
        var el4 = findViewById<ImageView>(R.id.autobusus)
        setPivotX(el4,el4.width.toFloat()/2) // Установление точки поворота
        setPivotY(el4,el4.height.toFloat()*2)
        setRotation(el4,-angle.toFloat()/5) // Осуществление поворота
        el4.setAlpha(((0.33 - (min(new_angle,0.33)))*3).toFloat()) // Установление прозрачности линейно в зависимости от угла
    }

    // Поворот при отпускании пальца
    fun check(angle:Double){
        var el = findViewById<ImageView>(R.id.image)
        var el2 = findViewById<ImageView>(R.id.image2)
        var el3 = findViewById<ImageView>(R.id.autobusus)
        var el4 = findViewById<ImageView>(R.id.carar)
        var e = findViewById<ConstraintLayout>(R.id.card).getChildAt(0)

        // Если последнее касание было в левой части экрана -> открыть окно предложения парковок
        if(angle > 20.0f){
            intent = Intent(this@SwipeChoice,OfferParking::class.java)
            startActivity(intent) // Создание нового окна
        }
        // Если последнее касание было в правой части экрана -> открыть окно расписаний маршрутов общественного транспорта
        else if(angle < -20.0f){
            intent = Intent(this@SwipeChoice,Schedule::class.java)
            startActivity(intent) // Создание нового окна
        }
        // Возвращение изначального цвета
        e.setBackgroundColor(0xFFBB0000.toInt())
        // Возвращение изначального поворота карточки
        setRotation(el, 0f)
        setRotation(el2,0f)
        setRotation(el3,0f)
        setRotation(el4,0f)

    }

    // Получение угла в зависимости от точки касания
    fun get_angle(x:Double,y:Double) : Double{
        // Получение высоты и ширины устройства
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels

        // Угол высчитывается между направлением от точки находящейся на расстоянии ширины экран / 2
        // относительно левого нижнего края экрана
        // и точкой касания
        return atan2(width/2.0f - x,height-y)*180/3.1416
    }
}
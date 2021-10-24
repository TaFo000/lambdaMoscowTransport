package com.example.moscowtransportlambda

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.core.view.ViewCompat.setY

class Route  : ComponentActivity(){
    // Экран маршрутов общественного транспорта

    // Создание экрана
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.route_layout) // Создание макета расположения элементов интерфейса

        // Обработчик кнопки возвращения на прошлый экран
        var btn = findViewById<Button>(R.id.bttn)
        btn.setOnClickListener {
            this@Route.finish() // Завершение текущего экрана
        }

        // Получение высоты устройства
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels

        // Скрытие уведомления
        var bot = findViewById<ImageView>(R.id.imageView11)
        setY(bot,height.toFloat())
    }

    // Обработчик касаний пользователя
    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Считывание второй координаты точки касания
        val y = event.y.toInt()

        // Получение высоты экрана
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels

        // Обработчик нажатий
        var bot = findViewById<ImageView>(R.id.imageView11)
        when (event.action) {
            // Когда пользователь продолжает нажимать на экран
            MotionEvent.ACTION_MOVE -> {
                if(y <= height-bot.height){ // Если он вытащил уведомление на расстояние равное высоте элемента уведомления
                    setY(bot,(height-bot.height).toFloat()) // Фиксирует расположение уведомления
                }else{
                    setY(bot,y.toFloat()) // То спокойно изменяет высоту левого края уведомления на позицию точки нажатия
                }
            }
            // Когда пользователь перестал нажимать на экран
            MotionEvent.ACTION_UP -> {
                if(y <= height - bot.height){ // Если последнее касание было произведено в области от верхнего края до области нижнего края за вычетом высоты уведомления
                    setY(bot,(height-bot.height).toFloat()) // Уведомление показывается полностью
                }else{
                    setY(bot,height.toFloat()) // Уведомление скрывается
                }
            }
        }
        return false
    }
}
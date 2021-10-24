package com.example.moscowtransportlambda

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class OfferParking : ComponentActivity() {
    // Экран предложения маршрута до парковки

    // Создание Экрана
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.offer) // Рендер макета расположения элементов

        // Обработчик нажаий на кнопку возвращения к предыдущему окну
        var btn = findViewById<Button>(R.id.go_back_button)
        btn.setOnClickListener {
            this@OfferParking.finish() // Завершение текущего окна
        }

    }
}
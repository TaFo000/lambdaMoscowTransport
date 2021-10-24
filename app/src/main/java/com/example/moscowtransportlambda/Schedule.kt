package com.example.moscowtransportlambda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class Schedule : ComponentActivity() {
    // Окно расписания общественного транспорта

    // Создание окна
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule) // Рендер макета расположения элементов

        // Получение элементов интерфейса
        val param_btn = findViewById<ImageButton>(R.id.params)
        val route_btn = findViewById<ImageButton>(R.id.route)
        val back_btn = findViewById<Button>(R.id.back_btn)
        // Обработчик нажатия на кнопку перехода к экрану параметров построения маршрутов для общественого транспорта
        param_btn.setOnClickListener{
            var intent = Intent(this@Schedule,Params::class.java)
            startActivity(intent) // Создание нового окна
        }
        // Обработчик нажатия на кнопку перехода к экрану маршрутов общественного транспорта
        route_btn.setOnClickListener{
            var intent = Intent(this@Schedule,Route::class.java)
            startActivity(intent) // Создание нового экна
        }
        // Обработчик нажатий на кнопку возвращения назад
        back_btn.setOnClickListener{
            this@Schedule.finish() // Возвращение к предыдущему окну
        }
    }
}
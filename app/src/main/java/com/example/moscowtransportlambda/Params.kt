package com.example.moscowtransportlambda

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class Params: ComponentActivity() {
    // Экран параметров маршрута общественного транспорта

    // Создание окна
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.params_layout) // Рендер макета расположения элементов

        // Обработчик нажатий на кнопку возвращения к предыдущему окну
        var btn = findViewById<Button>(R.id.return_btn)
        btn.setOnClickListener {
            this@Params.finish() // Завершение текущего окна
        }
    }
}
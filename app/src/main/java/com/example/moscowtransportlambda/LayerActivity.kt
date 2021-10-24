package com.example.moscowtransportlambda

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class LayerActivity : ComponentActivity() {
    // Экран слоёв

    // Создание окна
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layers) // Рендер макета расположения элементов

        // Обработчик нажатий на кнопку возвращения назад
        var back = findViewById<ImageButton>(R.id.go_back_btn)
        back.setOnClickListener{
            this@LayerActivity.finish() // Завершение текущего окна
        }
    }
}
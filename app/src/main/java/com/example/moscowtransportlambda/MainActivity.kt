package com.example.moscowtransportlambda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    // Главный экран

    // Создание окна
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen) // Рендер макета расположения элементов

        // Обработчик нажатия на кнопку "КУДА ПОЕДЕМ?"
        var kuda = findViewById<Button>(R.id.kuda_btn)
        kuda.setOnClickListener {
            // Создание окна выбора свайпами для выбора транспорта и данных маршрута
            var intent = Intent(this@MainActivity,SwipeChoice::class.java)
            startActivity(intent) // Переход к созданному окну
        }

        // Обработчик нажатия на кнопку слоев
        var layerss = findViewById<Button>(R.id.layers_btn)
        layerss.setOnClickListener {
            // Создание окна в котором можно изменять включенные слои на карте
            var yintent = Intent(this@MainActivity,LayerActivity::class.java)
            startActivity(yintent) // Переход к новому окну
        }
    }
}

package com.example.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val city = intent.getStringExtra("city")

        val bogota = City("Bogota", 12, "Cloudy")
        val medellin = City("Medellin", 24, "Sunny")

        when (city) {
            "Bogota" -> {
                textDegrees.text = bogota.degrees.toString() + "º"
                textCity.text = bogota.name
                textState.text = bogota.state
            }
            "Medellin" -> {
                textDegrees.text = medellin.degrees.toString() + "º"
                textCity.text = medellin.name
                textState.text = medellin.state
            }
            else -> {
                Toast.makeText(this, "Information not found", Toast.LENGTH_LONG).show()
            }
        }

    }
}
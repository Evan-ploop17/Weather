package com.example.clima

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cities.*

class Cities : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        btnBogota.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("city","3688689")
            startActivity(intent)
        }

        btnMedellin.setOnClickListener {
            Toast.makeText(this,"Medellín", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("city","3674962")
            startActivity(intent)
        }

    }
}
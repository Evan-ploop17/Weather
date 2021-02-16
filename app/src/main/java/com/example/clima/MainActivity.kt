package com.example.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val city = intent.getStringExtra("city")

        if(Network.thereIsNetwork(this)){
            // Execute HTTP request
                Toast.makeText(this, "Hay red", Toast.LENGTH_LONG).show()
                requestHTTPVolley("https://api.openweathermap.org/data/2.5/weather?id=3674962&appid=d83db4f259a5b6e14bb72ca03f55742d")
        }else{
            // Show a message

        }


    }

    private fun requestHTTPVolley(url:String){

        val queue = Volley.newRequestQueue(this)
        val request = StringRequest(Request.Method.GET, url, Response.Listener<String>{
            response->
            try{
                Log.d("http",response)

                val gson = Gson()
                val city = gson.fromJson(response, City::class.java)
                Log.d("city", city.name)

                textDegrees.text = city.main?.temp.toString() + "º"
                textCity.text = city.name
                textState.text = city.weather?.get(0)?.description
            }catch (e: Exception){
            }
        }, Response.ErrorListener {})
        queue.add(request)
    }

}
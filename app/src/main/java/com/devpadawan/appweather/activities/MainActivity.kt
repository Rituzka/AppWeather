package com.devpadawan.appweather.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devpadawan.appweather.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_api.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }

        /*To get only temperature and humidity from API:
        Array []
           "list"
               "dt"
               "main"
                   "temp"
                   "humidity"
         So, we have to create 3 data classes
         */

    }
}
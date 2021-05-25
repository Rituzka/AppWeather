package com.devpadawan.appweather.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpadawan.appweather.service.ApiWeather
import com.devpadawan.appweather.R
import com.devpadawan.appweather.model.Meteorology
import kotlinx.android.synthetic.main.activity_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WeatherActivity : AppCompatActivity() {

    val URL = "https://samples.openweathermap.org"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        weather_recycler.layoutManager = LinearLayoutManager(this)
        weather_recycler.adapter = null

        val retrofitWeather = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiWeather = retrofitWeather.create(ApiWeather::class.java)


        val callWeather = apiWeather.getWeather()
        callWeather.enqueue(object: Callback<Meteorology>{
            override fun onResponse(call: Call<Meteorology>, response: Response<Meteorology>?) {
                if (response != null) {
                    for(res in response.body().list){
                        Log.d("TAG response: ", res.main.temp)
                    }
                }
                if (response != null) {
                    weather_recycler.adapter = WeatherAdapter(response.body().list)
                }
            }

            override fun onFailure(call: Call<Meteorology>, t: Throwable?) {
                Log.e("TAG failure: ", t.toString())
            }

        })
    }
}
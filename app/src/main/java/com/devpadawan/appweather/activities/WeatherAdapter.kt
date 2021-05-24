package com.devpadawan.appweather.activities

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpadawan.appweather.model.Weather
import kotlinx.android.synthetic.main.list_item_weather.view.*
import java.text.SimpleDateFormat
import java.util.*

class WeatherAdapter(val meteorology: ArrayList<Weather>):
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    class WeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindWeather(weather: Weather){
            val date = Date(weather.dt.toLong()*1000)
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val date1 = sdf.format(date)

            Log.d("TAG WeatherAdapter: ", date1)

            itemView.txt_date.text = date1
            itemView.txt_temp.text = weather.main.temp
            itemView.txt_hum.text = weather.main.humidity

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {

    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        
    }

    override fun getItemCount(): Int {
       return meteorology.size
    }


}
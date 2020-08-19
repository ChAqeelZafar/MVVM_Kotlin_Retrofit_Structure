package com.example.gui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var modelData : Model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/todos/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val request: RetrofitInterface =
            retrofit.create<RetrofitInterface>(RetrofitInterface::class.java)
        val call: Call<Model?>? = request.getJSON()

        call?.enqueue(object : Callback<Model?> {
            override fun onFailure(call: Call<Model?>, t: Throwable) {
                println("Failed ${t.message}")
            }

            override fun onResponse(call: Call<Model?>, response: Response<Model?>) {
                println(response.message())
                var model = response.body() as? Model
                if (model != null) {
                    modelData = model
                }
            }

        })


    }
}
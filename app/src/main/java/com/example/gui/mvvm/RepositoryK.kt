package com.example.gui.mvvm

import android.os.AsyncTask
import android.view.Display
import android.widget.Toast
import com.example.gui.Model
import com.example.gui.RetrofitInterface
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryK {
    private constructor(){

    }
    companion object {
        val instance: RepositoryK by lazy { RepositoryK() }
    }




    fun getData(deligate: AsyncResponse){
        setData(deligate)
    }

    fun setData(deligate: AsyncResponse){
        TaskForApi(deligate).execute()
    }

    class TaskForApi(deligate: AsyncResponse) : AsyncTask<Void, Void, Void>(){
        lateinit var modelData : Model
        var asyncResponse = deligate
        override fun doInBackground(vararg p0: Void?): Void? {


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
                        asyncResponse.processFinish(modelData)
                    }
                }

            })

            return null
        }

//        override fun onPostExecute(result: Void?) {
//            super.onPostExecute(result)
//            asyncResponse.processFinish(modelData)
//        }
    }
}


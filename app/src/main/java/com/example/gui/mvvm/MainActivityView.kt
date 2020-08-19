package com.example.gui.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.gui.Model
import com.example.gui.R

class MainActivityView : AppCompatActivity() {
    lateinit var viewModelVm: ViewModelVm
    lateinit var modelData : Model


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)

        viewModelVm = ViewModelProviders.of(this).get(ViewModelVm::class.java)

        viewModelVm.getQuotes().observe(this, Observer {
            modelData = it
            displayQuotesList()
        })

    }

    fun displayQuotesList(){
        Toast.makeText(this, "Size is : ${modelData.title}", Toast.LENGTH_SHORT).show()
        println(modelData.id)
    }
}
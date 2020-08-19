package com.example.gui.mvvm

import com.example.gui.Model

interface AsyncResponse {
    fun processFinish(model: Model)
}
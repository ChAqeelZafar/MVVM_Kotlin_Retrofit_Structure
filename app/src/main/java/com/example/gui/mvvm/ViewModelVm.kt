package com.example.gui.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gui.Model

class ViewModelVm : ViewModel(), AsyncResponse {
    var mutableModel = MutableLiveData<Model>()
    lateinit var repositoryK: RepositoryK
    init {
        repositoryK = RepositoryK.instance
        repositoryK.getData(this)
    }



    fun getQuotes() : LiveData<Model>{
        return mutableModel
    }

    override fun processFinish(model: Model) {
        mutableModel.value = model
    }


}
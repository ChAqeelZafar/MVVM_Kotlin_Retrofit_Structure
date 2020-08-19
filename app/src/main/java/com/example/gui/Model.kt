package com.example.gui

import com.google.gson.annotations.SerializedName

class Model (
   @SerializedName("userId")
   val userId : Int,

   @SerializedName("id")
   val id : Int,

   @SerializedName("title")
   val title: String,

   @SerializedName("completed")
   val isCompleted: Boolean


)
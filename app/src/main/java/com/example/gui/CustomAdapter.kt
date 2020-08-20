package com.example.gui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(moviesList: ArrayList<Movie> ) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var moviesListInner = moviesList

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(movie: Movie) {
            val textViewName = itemView.findViewById(R.id.tv_name) as TextView
            val textViewTitle  = itemView.findViewById(R.id.tv_title) as TextView
            textViewName.text = movie.name
            textViewTitle.text = movie.title
        }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_holder, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(moviesListInner[position])
    }

    override fun getItemCount(): Int {
        return moviesListInner.size
    }


}
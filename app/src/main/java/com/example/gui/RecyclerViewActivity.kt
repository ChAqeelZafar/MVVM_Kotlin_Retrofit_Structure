package com.example.gui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var adapter: CustomAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    val moviesList = ArrayList<Movie>()

//     val moviesList = listOf(
//        Movie("Raising Arizona", "1987"),
//        Movie("Vampire's Kiss", "1988"),
//        Movie("Con Air", "1997"),
//        Movie("Gone in 60 Seconds", "1997"),
//        Movie("National Treasure", "2004"),
//        Movie("The Wicker Man", "2006"),
//        Movie("Ghost Rider", "2007"),
//        Movie("Knowing", "2009")
//    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

    moviesList.add(Movie("Raising Arizona", "1987"))
    moviesList.add(Movie("Vampire's Kiss", "1988"))
    moviesList.add(Movie("Vampire's Kiss", "1988"))
    moviesList.add(Movie("Gone in 60 Seconds", "1997"))
    moviesList.add(Movie("Raising Arizona", "1987"))
    moviesList.add(Movie("Vampire's Kiss", "1988"))
    moviesList.add(Movie("Vampire's Kiss", "1988"))
    moviesList.add(Movie("Gone in 60 Seconds", "1997"))
    moviesList.add(Movie("Raising Arizona", "1987"))
    moviesList.add(Movie("Vampire's Kiss", "1988"))
    moviesList.add(Movie("Vampire's Kiss", "1988"))
    moviesList.add(Movie("Gone in 60 Seconds", "1997"))

        linearLayoutManager = LinearLayoutManager(this)
        rv_list.layoutManager = linearLayoutManager

        adapter = CustomAdapter(moviesList as ArrayList<Movie>)
        rv_list.adapter = adapter

    }
}
package com.example.greedygame_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.greedygame_assignment.Adapter.GenreAdapter
import com.example.greedygame_assignment.ViewModel.GenreViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var genreListRecycler : RecyclerView
    lateinit var genreAdapter:GenreAdapter
    private val genreViewModel: GenreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        genreListRecycler = findViewById(R.id.genreListRecycler)

        genreViewModel.response.observe(this, Observer { response->
//                Log.d("Genres List","$response")
                genreListRecycler.layoutManager = GridLayoutManager(this,4)
                genreAdapter = GenreAdapter()
                genreListRecycler.adapter = genreAdapter
                genreAdapter.setListData(this,response.topTags.listTags)
                genreAdapter.notifyDataSetChanged()
            })


    }
}
package com.example.greedygame_assignment.Activity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.example.greedygame_assignment.Adapter.ViewPageAdapter
import com.example.greedygame_assignment.Fragments.AlbumFragment
import com.example.greedygame_assignment.Fragments.ArtistFragment
import com.example.greedygame_assignment.Fragments.TracksFragment
import com.example.greedygame_assignment.R
import com.example.greedygame_assignment.ViewModel.GenreViewModel
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreDetailActivity : AppCompatActivity() {

    private val genreViewModel: GenreViewModel by viewModels()

    public var tagName:String? = null

    lateinit var textTitle:TextView
    lateinit var textDescription:TextView

    private lateinit var pager: ViewPager // creating object of ViewPager
    private lateinit var tab: TabLayout  // creating object of TabLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre_detail)


        textTitle = findViewById(R.id.title_tag)
        textDescription = findViewById(R.id.txtDtails)
        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tab)

        tagName = intent.getStringExtra("genreName")

        genreViewModel.initViewModel(tagName.toString())

        genreViewModel.getGenreData(tagName.toString()).observe(this, Observer {response->
            Log.e("ResponseGenreDetails","$response")
            textTitle.text = response.tag.name
            textDescription.text = response.tag.wiki.descriptionSummery
        })

        setupTabLayout()

    }

    private fun setupTabLayout() {

        val adapter = ViewPageAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(AlbumFragment(), "ALBUMS")
        adapter.addFragment(ArtistFragment(), "ARTISTS")
        adapter.addFragment(TracksFragment(), "TRACKS")

        // Adding the Adapter to the ViewPager
        pager.adapter = adapter

        // bind the viewPager with the TabLayout.
        tab.setupWithViewPager(pager)

    }
}
package com.example.greedygame_assignment.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.greedygame_assignment.R
import com.example.greedygame_assignment.ViewModel.AlbumInfoViewModel
import com.example.greedygame_assignment.ViewModel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {


    public var albumName:String? = null
    public var artistName:String? = null

    lateinit var titleTrack: TextView
    lateinit var textDescription: TextView
    lateinit var imageViw: ImageView

    private val albumInfoViewModel: AlbumInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        titleTrack = findViewById(R.id.titleTrack)
        textDescription = findViewById(R.id.txtDescription)
        imageViw = findViewById(R.id.imageView2)

        albumName = intent.getStringExtra("albumName")
        artistName = intent.getStringExtra("artistName")


        albumInfoViewModel.getAlbumInfo(albumName.toString(),artistName.toString()).observe(this, Observer {response->
            titleTrack.text = response.album.albumName
            var image = response.album.imageList.get(1).image

            if (image.equals("")){
                Glide.with(this)
                    .load(R.drawable.no_image)
                    .into(imageViw)
            }else{
                Glide.with(this)
                    .load(image)
                    .into(imageViw)
            }

//            textDescription.text = response.album.wiki.summary
        })
    }
}
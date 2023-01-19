package com.example.greedygame_assignment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.greedygame_assignment.Activity.GenreDetailActivity
import com.example.greedygame_assignment.Adapter.AlbumAdapter
import com.example.greedygame_assignment.Adapter.ArtistAdapter
import com.example.greedygame_assignment.R
import com.example.greedygame_assignment.ViewModel.ArtistViewModel


class ArtistFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var artistListRecycler : RecyclerView
    private val artistViewModel: ArtistViewModel by activityViewModels()
    lateinit var artistAdapter:ArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_artist, container, false)

        artistListRecycler = view.findViewById<RecyclerView>(R.id.artistRecycler)

        var tagName = (activity as GenreDetailActivity).tagName

        if (tagName != null) {
            artistViewModel.getArtistList(tagName).observe(requireActivity(), Observer{ response->
                artistListRecycler.layoutManager = LinearLayoutManager(context)
                artistAdapter = ArtistAdapter()
                artistListRecycler.adapter = artistAdapter
                artistAdapter.setListData(requireActivity(),response.artist.artistList)
                artistAdapter.notifyDataSetChanged()
            })
        }

        return view
    }


}
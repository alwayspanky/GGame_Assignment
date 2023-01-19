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
import com.example.greedygame_assignment.Adapter.ArtistAdapter
import com.example.greedygame_assignment.Adapter.TracksAdapter
import com.example.greedygame_assignment.R
import com.example.greedygame_assignment.ViewModel.ArtistViewModel
import com.example.greedygame_assignment.ViewModel.TrackViewModel


class TracksFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var trackListRecycler : RecyclerView
    private val trackViewModel: TrackViewModel by activityViewModels()
    lateinit var trackAdapter: TracksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_tracks, container, false)

        trackListRecycler = view.findViewById<RecyclerView>(R.id.trackRecycler)

        var tagName = (activity as GenreDetailActivity).tagName

        if (tagName != null) {
            trackViewModel.getTrackList(tagName).observe(requireActivity(), Observer{ response->
                trackListRecycler.layoutManager = LinearLayoutManager(context)
                trackAdapter = TracksAdapter()
                trackListRecycler.adapter = trackAdapter
                trackAdapter.setListData(requireActivity(),response.tracks.trackList)
                trackAdapter.notifyDataSetChanged()
            })
        }

        return view
    }

}
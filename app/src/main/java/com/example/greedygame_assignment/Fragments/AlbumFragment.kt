package com.example.greedygame_assignment.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.greedygame_assignment.Activity.GenreDetailActivity
import com.example.greedygame_assignment.Adapter.AlbumAdapter
import com.example.greedygame_assignment.R
import com.example.greedygame_assignment.ViewModel.AlbumViewModel
import com.example.greedygame_assignment.ViewModel.GenreViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlbumFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var albumListRecycler : RecyclerView
    private val albumViewModel: AlbumViewModel by activityViewModels()
    lateinit var albumAdapter:AlbumAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_album, container, false)

        albumListRecycler = view.findViewById<RecyclerView>(R.id.albumRecycler)

        var tagName = (activity as GenreDetailActivity).tagName

        if (tagName != null) {
            albumViewModel.getAlbumList(tagName).observe(requireActivity(),Observer{response->
                albumListRecycler.layoutManager = LinearLayoutManager(context)
                albumAdapter = AlbumAdapter()
                albumListRecycler.adapter = albumAdapter
                albumAdapter.setListData(requireActivity(),response.album.albumList)
                albumAdapter.notifyDataSetChanged()
            })
        }

        return view
    }

}
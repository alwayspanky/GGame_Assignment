package com.example.greedygame_assignment.ViewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.greedygame_assignment.Model.*
import com.example.greedygame_assignment.Repository.AlbumRepository
import com.example.greedygame_assignment.Repository.ArtistRepository
import com.example.greedygame_assignment.Repository.GenreRepository
import com.example.greedygame_assignment.Repository.TrackRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackViewModel
@Inject
constructor(private val trackRepository: TrackRepository): ViewModel() {


    fun getTrackList(tagName: String):LiveData<TracksModel>{
        return  trackRepository.getTrackList(tagName)
            .catch { e->
                Log.d("main","${e.message}")
            }.asLiveData()
    }

}
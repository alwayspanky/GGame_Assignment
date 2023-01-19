package com.example.greedygame_assignment.ViewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.greedygame_assignment.Model.AlbumInfoModel
import com.example.greedygame_assignment.Model.AlbumModel
import com.example.greedygame_assignment.Model.GenreDetailsModel
import com.example.greedygame_assignment.Model.GenresModel
import com.example.greedygame_assignment.Repository.AlbumRepository
import com.example.greedygame_assignment.Repository.GenreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel
@Inject
constructor(private val albumRepository: AlbumRepository): ViewModel() {


    fun getAlbumList(tagName: String):LiveData<AlbumModel>{
        return  albumRepository.getAlbumList(tagName)
            .catch { e->
                Log.d("main","${e.message}")
            }.asLiveData()
    }




}
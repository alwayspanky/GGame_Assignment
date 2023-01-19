package com.example.greedygame_assignment.ViewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.greedygame_assignment.Model.AlbumInfoModel
import com.example.greedygame_assignment.Model.AlbumModel
import com.example.greedygame_assignment.Model.GenreDetailsModel
import com.example.greedygame_assignment.Model.GenresModel
import com.example.greedygame_assignment.Repository.AlbumInfoRepository
import com.example.greedygame_assignment.Repository.AlbumRepository
import com.example.greedygame_assignment.Repository.GenreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumInfoViewModel
@Inject
constructor(private val albumInfoRepository: AlbumInfoRepository): ViewModel() {




    fun getAlbumInfo(albumName: String,artistName:String ):LiveData<AlbumInfoModel>{
        return  albumInfoRepository.getAlbumInfo(albumName,artistName)
            .catch { e->
                Log.d("main","${e.message}")
            }.asLiveData()
    }


}
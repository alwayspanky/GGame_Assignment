package com.example.greedygame_assignment.ViewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.greedygame_assignment.Model.GenreDetailsModel
import com.example.greedygame_assignment.Model.GenresModel
import com.example.greedygame_assignment.Repository.GenreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenreViewModel
@Inject
constructor(private val genreRepository: GenreRepository): ViewModel() {

    var tag:String? = null
    fun initViewModel(tagName:String){
        tag = tagName
    }


    val response:LiveData<GenresModel> = genreRepository.getGenreData()
        .catch { e->
            Log.d("main","${e.message}")
        }.asLiveData()

    fun getGenreData(tagName: String):LiveData<GenreDetailsModel>{
        return  genreRepository.getGenreDetails(tagName)
            .catch { e->
                Log.d("main","${e.message}")
            }.asLiveData()
    }




}
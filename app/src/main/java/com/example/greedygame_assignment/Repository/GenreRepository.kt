package com.example.greedygame_assignment.Repository

import com.example.greedygame_assignment.Model.GenreDetailsModel
import com.example.greedygame_assignment.Model.GenresModel
import com.example.greedygame_assignment.Retrofit.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GenreRepository
@Inject
constructor(private val apiClient: ApiClient) {

    fun getGenreData():Flow<GenresModel>  = flow {
        val response = apiClient.getGenreData()
        emit(response)
    }.flowOn(Dispatchers.IO)

//    private val genere = MutableLiveData<GenreDetailsModel>()
//    val genreDetailData:LiveData<GenreDetailsModel>
//    get() = genere

    fun getGenreDetails(tagName:String):Flow<GenreDetailsModel>  = flow {
        val response = apiClient.getGenreDetails(tagName)
        emit(response)
    }.flowOn(Dispatchers.IO)
}
package com.example.greedygame_assignment.Repository

import com.example.greedygame_assignment.Model.AlbumInfoModel
import com.example.greedygame_assignment.Model.AlbumModel
import com.example.greedygame_assignment.Retrofit.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AlbumRepository
@Inject
constructor(private val apiClient: ApiClient) {

    fun getAlbumList(tagName:String):Flow<AlbumModel>  = flow {
        val response = apiClient.getAlbumList(tagName)
        emit(response)
    }.flowOn(Dispatchers.IO)

}
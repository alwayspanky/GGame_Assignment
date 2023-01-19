package com.example.greedygame_assignment.Repository

import com.example.greedygame_assignment.Model.AlbumInfoModel
import com.example.greedygame_assignment.Retrofit.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AlbumInfoRepository
@Inject
constructor(private val apiClient: ApiClient) {

    fun getAlbumInfo(albumName:String,artistName:String):Flow<AlbumInfoModel>  = flow {
        val response = apiClient.getAlbumInfo(albumName,artistName)
        emit(response)
    }.flowOn(Dispatchers.IO)
}
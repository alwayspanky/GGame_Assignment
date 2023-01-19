package com.example.greedygame_assignment.Repository

import com.example.greedygame_assignment.Model.AlbumModel
import com.example.greedygame_assignment.Model.ArtistsModel
import com.example.greedygame_assignment.Model.TracksModel
import com.example.greedygame_assignment.Retrofit.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TrackRepository
@Inject
constructor(private val apiClient: ApiClient) {

    fun getTrackList(tagName:String):Flow<TracksModel>  = flow {
        val response = apiClient.getTrackList(tagName)
        emit(response)
    }.flowOn(Dispatchers.IO)
}
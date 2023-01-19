package com.example.greedygame_assignment.Retrofit


import com.example.greedygame_assignment.Constants.Constants
import com.example.greedygame_assignment.Model.*
import javax.inject.Inject

class ApiClient @Inject constructor(private val apiInterface: ApiInterface) {


    suspend fun getGenreData(): GenresModel = apiInterface.getGenreData(
                        "user.gettoptags","RJ",Constants.API_KEY,"json")

    suspend fun getGenreDetails(tagName:String): GenreDetailsModel = apiInterface.getGenreInfoDetail(
        "tag.getinfo",tagName,Constants.API_KEY,"json")

    suspend fun getAlbumList(tagName:String): AlbumModel = apiInterface.getAlbumsList(
        Constants.API_KEY,"json","tag.gettopalbums",tagName)

    suspend fun getArtistList(tagName:String): ArtistsModel = apiInterface.getArtistsList("tag.gettopartists",tagName,
        Constants.API_KEY,"json")

    suspend fun getTrackList(tagName:String): TracksModel = apiInterface.getTracksList("tag.gettoptracks",tagName,
        Constants.API_KEY,"json")

    suspend fun getAlbumInfo(albumName:String,artistName:String): AlbumInfoModel = apiInterface.getAlbumInfo("album.getinfo",
        Constants.API_KEY,artistName,albumName,"json")
}
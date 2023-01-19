package com.example.greedygame_assignment.Retrofit

import com.example.greedygame_assignment.Model.*
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("Content-Type: application/json")
    @GET("2.0/")
    suspend fun getGenreData(
        @Query("method") method:String,
        @Query("user") user:String,
        @Query("api_key") api_key:String,
        @Query("format") format:String
    ) : GenresModel

    @Headers("Content-Type: application/json")
    @GET("2.0/")
    suspend fun getGenreInfoDetail(
        @Query("method") method:String,
        @Query("tag") tag:String,
        @Query("api_key") api_key:String,
        @Query("format") format:String
    ) : GenreDetailsModel

    @Headers("Content-Type: application/json")
    @GET("2.0/")
    suspend fun getAlbumsList(
        @Query("api_key") api_key:String,
        @Query("format") format:String,
        @Query("method") method:String,
        @Query("tag") tag:String,
    ) : AlbumModel

    @Headers("Content-Type: application/json")
    @GET("2.0/")
    suspend fun getArtistsList(
        @Query("method") method:String,
        @Query("tag") tag:String,
        @Query("api_key") api_key:String,
        @Query("format") format:String
    ) : ArtistsModel

    @Headers("Content-Type: application/json")
    @GET("2.0/")
    suspend fun getTracksList(
        @Query("method") method:String,
        @Query("tag") tag:String,
        @Query("api_key") api_key:String,
        @Query("format") format:String
    ) : TracksModel

    @Headers("Content-Type: application/json")
    @GET("2.0/")
    suspend fun getAlbumInfo(
        @Query("method") method:String,
        @Query("api_key") api_key:String,
        @Query("artist") artist:String,
        @Query("album") album:String,
        @Query("format") format:String
    ) : AlbumInfoModel

}
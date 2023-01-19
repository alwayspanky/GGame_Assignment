package com.example.greedygame_assignment.Model

import com.google.gson.annotations.SerializedName

data class AlbumModel(
    @SerializedName("albums") var album:Album
)

data class Album(
    @SerializedName("album") var albumList:MutableList<AlbumDetail>
)
data class AlbumDetail(
    @SerializedName("name") var titleName:String,
    @SerializedName("artist")  var artist:Artist,
    @SerializedName("image")  var imageList:MutableList<AlbumImageList>
)

data class Artist(
    @SerializedName("name") var artistName:String

    )

data class AlbumImageList(
    @SerializedName("#text") var imageUrl:String

)
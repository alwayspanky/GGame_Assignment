package com.example.greedygame_assignment.Model

import com.google.gson.annotations.SerializedName

data class AlbumInfoModel(
    @SerializedName("album") var album:AlbumI
)


data class AlbumI(
    @SerializedName("name") var albumName:String,
    @SerializedName("artist") var artistName:String,
    @SerializedName("playcount") var playcount:String,
    @SerializedName("image") var imageList: MutableList<AlbumInfoImageList>,
    @SerializedName("wiki") var wiki: WikiSummary
)

data class AlbumInfoImageList(
    @SerializedName("#text") var image:String
)

data class WikiSummary(
    @SerializedName("summary") var summary:String
    )


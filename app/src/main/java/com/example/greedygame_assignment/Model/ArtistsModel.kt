package com.example.greedygame_assignment.Model

import com.google.gson.annotations.SerializedName

data class ArtistsModel(
    @SerializedName("topartists") var artist:Artists
)

data class Artists(
    @SerializedName("artist") var artistList:MutableList<ArtistDetail>
)
data class ArtistDetail(
    @SerializedName("name") var artistName:String,
    @SerializedName("image")  var imageList:MutableList<ArtistImageList>
)

data class ArtistImageList(
    @SerializedName("#text") var imageUrl:String

)
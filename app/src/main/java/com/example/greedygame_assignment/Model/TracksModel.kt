package com.example.greedygame_assignment.Model

import com.google.gson.annotations.SerializedName

data class TracksModel(
    @SerializedName("tracks") var tracks:Tracks
)

data class Tracks(
    @SerializedName("track") var trackList:MutableList<TrackDetails>
)
data class TrackDetails(
    @SerializedName("name") var trackName:String,
    @SerializedName("artist")  var trackArtist:TrackArtist,
    @SerializedName("image")  var imageList:MutableList<TrackImageList>
)

data class TrackArtist(
    @SerializedName("name") var artistName:String

)

data class TrackImageList(
    @SerializedName("#text") var imageUrl:String

)
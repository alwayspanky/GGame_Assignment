package com.example.greedygame_assignment.Model

import com.google.gson.annotations.SerializedName

data class GenreDetailsModel(
    @SerializedName("tag") var tag:TagDetails
)

data class TagDetails(
    @SerializedName("name") var name:String,
    @SerializedName("wiki") var wiki:WikiDetails

)

data class WikiDetails(
    @SerializedName("summary") var descriptionSummery:String
)
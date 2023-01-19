package com.example.greedygame_assignment.Model

import com.google.gson.annotations.SerializedName

data class GenresModel(

    @SerializedName("toptags") var topTags:Tags

)

data class Tags(
    @SerializedName("tag") var listTags:MutableList<TagsDetail>

)

data class TagsDetail(
    @SerializedName("name") var name:String

)
package nick.dev.gallery.network

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    val id:Int,
    @SerializedName("weight")
    val weight:Int,
    @SerializedName("height")
    val height:Int,
    @SerializedName("url")
    val url:String,
    @SerializedName("photographer")
    val photographer:String,
    @SerializedName("photographer_url")
    val photographerUrl:String,
    @SerializedName("photographer_id")
    val photographerId:Int,
    @SerializedName("avg_color")
    val avgColor:String,
    @SerializedName("src")
    val src:Src,
    @SerializedName("liked")
    val liked:Boolean,
    @SerializedName("alt")
    val alt:String
)

data class Src(
    @SerializedName("original")
    val original:String,
    @SerializedName("large2x")
    val large2x:String,
    @SerializedName("large")
    val large:String,
    @SerializedName("medium")
    val medium:String,
    @SerializedName("small")
    val small:String,
    @SerializedName("portrait")
    val portrait:String,
    @SerializedName("landscape")
    val landscape:String,
    @SerializedName("tiny")
    val tiny:String
)


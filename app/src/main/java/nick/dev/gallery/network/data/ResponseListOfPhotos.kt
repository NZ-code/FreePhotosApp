package nick.dev.gallery.network.data

import com.google.gson.annotations.SerializedName
import nick.dev.gallery.network.Photo

data class ResponseListOfPhotos(
    @SerializedName("page")
    val page:Int,
    @SerializedName("per_page")
    val perPage:Int,
    @SerializedName("photos")
    val photos:List<Photo>,
    @SerializedName("total_results")
    val totalResults:Int,
    @SerializedName("next_page")
    val nextPage:String

)

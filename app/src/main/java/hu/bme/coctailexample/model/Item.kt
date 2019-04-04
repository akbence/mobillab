package hu.bme.coctailexample.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("sample")
    var uri: String? = null
)
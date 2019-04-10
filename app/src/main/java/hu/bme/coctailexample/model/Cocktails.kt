package hu.bme.coctailexample.model

import com.google.gson.annotations.SerializedName


data class Cocktails(
    @SerializedName("drinks")
    var drinks: List<Item>? = null
)
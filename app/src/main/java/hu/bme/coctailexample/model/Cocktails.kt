package hu.bme.coctailexample.model

import com.google.gson.annotations.SerializedName


data class Cocktails(
    @SerializedName("drinkname")
    var drinkName: String? = null,
    @SerializedName("description")
    var description: String? = null
)
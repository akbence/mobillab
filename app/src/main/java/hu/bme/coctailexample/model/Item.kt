package hu.bme.coctailexample.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("idDrink")
    var id: String? = null,
    @SerializedName("strDrink")
    var name: String? = null,
    @SerializedName("strInstructions")
    var instructions: String? = null,
    @SerializedName("strDrinkThumb")
    var url: String? = null
)
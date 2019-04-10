package hu.bme.coctailexample.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("strDrink")
    var href: String? = null,
    @SerializedName("strAlcoholic")
    var items: String? = null
)
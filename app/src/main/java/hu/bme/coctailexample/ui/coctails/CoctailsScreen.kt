package hu.bme.coctailexample.ui.coctails

import hu.bme.coctailexample.model.Item


interface CoctailsScreen{
    fun showArtists(artists: List<Item>?)
    fun showNetworkError(errorMsg: String)
}
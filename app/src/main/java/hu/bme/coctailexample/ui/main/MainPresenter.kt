package hu.bme.coctailexample.ui.main

import hu.bme.coctailexample.ui.Presenter

class MainPresenter : Presenter<MainScreen>() {

    fun showArtistsSearchList(artistSearchTerm: String) {
        screen?.showArtists(artistSearchTerm)
    }
}
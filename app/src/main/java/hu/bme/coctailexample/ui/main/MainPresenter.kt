package hu.bme.coctailexample.ui.main

import hu.bme.coctailexample.ui.Presenter

class MainPresenter : Presenter<MainScreen>() {

    fun showCoctailsSearchList(coctailSearchTerm: String) {
        screen?.showCoctails(coctailSearchTerm)
    }
}
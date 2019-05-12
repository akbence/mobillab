package hu.bme.coctailexample.ui.main

interface MainScreen {
    fun showCoctails(coctailSearchTerm: String)
    fun showNetworkError(coctailSearchTerm: String)

}
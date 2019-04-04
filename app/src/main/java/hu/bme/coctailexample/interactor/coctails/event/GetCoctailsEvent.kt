package hu.bme.coctailexample.interactor.coctails.event

import hu.bme.coctailexample.model.Cocktails

data class GetCoctailsEvent(
    var code: Int = 0,
    var artists: List<Cocktails>? = null,
    var throwable: Throwable? = null
)
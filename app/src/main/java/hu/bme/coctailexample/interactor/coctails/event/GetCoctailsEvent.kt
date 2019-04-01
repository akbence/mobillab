package hu.bme.coctailexample.interactor.coctails.event

import hu.bme.coctailexample.model.Coctail

data class GetCoctailsEvent(
    var code: Int = 0,
    var artists: List<Coctail>? = null,
    var throwable: Throwable? = null
)
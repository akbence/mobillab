package hu.bme.coctailexample.interactor.coctails.event

import hu.bme.coctailexample.model.Item

data class GetCoctailsEvent(
    var code: Int = 0,
    var drinks: List<Item>? = null,
    var throwable: Throwable? = null
)
package hu.bme.coctailexample.interactor.coctails

import android.util.Log
import hu.bme.coctailexample.database.Coctail
import hu.bme.coctailexample.model.Cocktails
import hu.bme.coctailexample.database.CoctailDao
import hu.bme.coctailexample.interactor.coctails.event.GetCoctailsEvent
import hu.bme.coctailexample.model.Item
import hu.bme.coctailexample.network.CoctailsApi
/*
import hu.bme.coctailexample.interactor.artists.event.GetArtistsEvent
import hu.bme.coctailexample.network.ArtistsApi
import hu.bme.coctailexample.network.TokenApi
*/
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class CoctailsInteractor @Inject constructor(private var coctailsApi: CoctailsApi,private var coctailDao: CoctailDao) {

    fun getCoctails(artistQuery: String) {

        val event = GetCoctailsEvent()

        try {

            val coctailsQueryCall = coctailsApi.getCoctails("whiskey")
            val response = coctailsQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }


            val mockedCoctails=coctailDao.getCoctails().map { Item(
                id=  it.id.toString(),
                name = it.name?: "",
                url= it.imgURL?: "",
                instructions = it.description?:""
            ) }

            event.code = response.code()
            event.drinks = response.body()?.drinks
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun addCoctail(coctail: Item) {
        val coctailEntity = Coctail(
            id =  null,
            name = coctail.name?: "",
            imgURL= coctail.url?: "",
            description = coctail.instructions?:""
        )
        coctailDao.insert(coctailEntity)
    }

}
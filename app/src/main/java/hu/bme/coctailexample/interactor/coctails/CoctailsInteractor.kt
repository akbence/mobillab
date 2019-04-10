package hu.bme.coctailexample.interactor.coctails

import android.util.Log
import hu.bme.coctailexample.interactor.coctails.event.GetCoctailsEvent
import hu.bme.coctailexample.network.CoctailsApi
/*
import hu.bme.coctailexample.interactor.artists.event.GetArtistsEvent
import hu.bme.coctailexample.network.ArtistsApi
import hu.bme.coctailexample.network.TokenApi
*/
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class CoctailsInteractor @Inject constructor(private var coctailsApi: CoctailsApi) {

    fun getCoctails(artistQuery: String) {

        //val tokenQueryCall = tokenApi.getToken()
        val event = GetCoctailsEvent()


        try {



            val artistsQueryCall = coctailsApi.getCoctails(artistQuery)

            val response = artistsQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.drinks = response.body()?.drinks
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}
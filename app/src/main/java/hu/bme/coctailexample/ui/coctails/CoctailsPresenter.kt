package hu.bme.coctailexample.ui.coctails

import hu.bme.coctailexample.interactor.coctails.CoctailInteractor
import hu.bme.coctailexample.interactor.coctails.event.GetCoctailsEvent
import hu.bme.coctailexample.model.Cocktails
import hu.bme.coctailexample.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class CoctailsPresenter @Inject constructor(private val executor: Executor, private val coctailsInteractor: CoctailInteractor) : Presenter<CoctailsScreen>() {

    override fun attachScreen(screen: CoctailsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshArtists(artistQuery: String) {
        executor.execute {
            coctailsInteractor.getArtists(artistQuery)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetCoctailsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.artists != null) {
                   // screen?.showArtists(event.artists as MutableList<Cocktails>)
                }

            }
        }
    }
}
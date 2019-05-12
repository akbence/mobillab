package hu.bme.coctailexample.ui.main

import hu.bme.coctailexample.interactor.coctails.CoctailsInteractor
import hu.bme.coctailexample.interactor.coctails.event.GetCoctailsEvent
import hu.bme.coctailexample.model.Item
import hu.bme.coctailexample.ui.Presenter
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter  @Inject constructor(private val executor: Executor, private val coctailsInteractor: CoctailsInteractor) : Presenter<MainScreen>() {

    fun showCoctailsSearchList(coctailSearchTerm: String) {
        screen?.showCoctails(coctailSearchTerm)
    }

    fun refreshCoctails(){
        executor.execute {
            coctailsInteractor.getCoctails("ginfizz")
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
                if (event.drinks != null) {
                    screen?.showCoctails("asd")
                }

            }
        }
    }
}
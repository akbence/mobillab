package hu.bme.coctailexample.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.coctailexample.interactor.coctails.CoctailsInteractor
import hu.bme.coctailexample.ui.coctails.CoctailsPresenter
//import hu.bme.coctailexample.interactor.artists.ArtistsInteractor
//import hu.bme.coctailexample.ui.artists.ArtistsPresenter
import hu.bme.coctailexample.ui.main.MainPresenter
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, coctailsInteractor: CoctailsInteractor) = MainPresenter(executor,coctailsInteractor)

    @Provides
    @Singleton
    fun artistsPresenter(executor: Executor, coctailsInteractor: CoctailsInteractor) = CoctailsPresenter(executor, coctailsInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}
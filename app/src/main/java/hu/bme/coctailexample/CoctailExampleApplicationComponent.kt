package hu.bme.coctailexample

import dagger.Component
import hu.bme.coctailexample.database.DatabaseModule
import hu.bme.coctailexample.interactor.InteractorModule
import hu.bme.coctailexample.network.NetworkModule
import hu.bme.coctailexample.ui.UIModule
import hu.bme.coctailexample.ui.coctails.CoctailsFragment
//import hu.bme.coctailexample.ui.artists.ArtistsFragment
import hu.bme.coctailexample.ui.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class,DatabaseModule::class])
interface CoctailExampleApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(artistsFragment: CoctailsFragment)
}
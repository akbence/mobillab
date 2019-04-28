package hu.bme.coctailexample.interactor

import dagger.Module
import dagger.Provides
import hu.bme.coctailexample.database.CoctailDao
import hu.bme.coctailexample.interactor.coctails.CoctailsInteractor
import hu.bme.coctailexample.network.CoctailsApi
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideCoctailsInteractor(coctailsApi: CoctailsApi,coctailDao:CoctailDao) = CoctailsInteractor(coctailsApi,coctailDao)
}
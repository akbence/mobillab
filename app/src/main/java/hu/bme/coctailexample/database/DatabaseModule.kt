package hu.bme.coctailexample.database

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideCoctailDao(context: Context): CoctailDao {
        return AppDatabase.getInstance(context).cocktailDao()
    }
}
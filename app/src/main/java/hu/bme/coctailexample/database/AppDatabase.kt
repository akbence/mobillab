package hu.bme.coctailexample.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [(Coctail::class)], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cocktailDao(): CoctailDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context.applicationContext, AppDatabase::class.java, "coctailMockdb")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

        fun getMockDB(
            context: Context
        ): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java)
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
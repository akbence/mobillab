package hu.bme.coctailexample.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

@Dao
interface CoctailDao {
    @Query("SELECT * from Coctail")
    fun getCoctails(): List<Coctail>

    @Query("SELECT * from Coctail WHERE id = :id")
    fun getCoctail(id : Int): Coctail

    @Update
    fun updateCoctail(coctail: Coctail)

    @Insert
    fun insert(coctail: Coctail)

    @Query("DELETE FROM Coctail")
    fun deleteAll()
}
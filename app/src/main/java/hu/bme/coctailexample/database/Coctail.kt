package hu.bme.coctailexample.database


import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Coctail")
data class Coctail(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "firstbrewed") var description: String,
    @ColumnInfo(name = "imgurl") var imgURL: String
)
package hu.bme.coctailexample.network



import hu.bme.coctailexample.model.Coctail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoctailApi {
    @GET("search")
    fun getCoctails(
        @Query("query") artist: String,
        @Query("type") type: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int): Call<Coctail>
}
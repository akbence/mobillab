package hu.bme.coctailexample.network



import hu.bme.coctailexample.model.Cocktails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoctailsApi {
    @GET("search")
    fun getCoctails(

        @Query("query") artist: String,
        @Query("type") type: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int): Call<Cocktails>

}
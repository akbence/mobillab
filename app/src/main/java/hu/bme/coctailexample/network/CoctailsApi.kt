package hu.bme.coctailexample.network



import hu.bme.coctailexample.model.Cocktails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CoctailsApi {
    @GET("search.php")
    fun getCoctails(

        @Query("s") coctails: String): Call<Cocktails>

}
package sanchez.jose.androidcodingchallenge.networking

import retrofit2.Call
import retrofit2.http.GET
import sanchez.jose.androidcodingchallenge.commands.BooksForSaleResponse

/**
 * Interface that holds all the endpoints of the app
 */
interface EbayService {

    @GET("books.json")
    fun getBooksForSale(): Call<List<BooksForSaleResponse>>
}
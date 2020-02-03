package sanchez.jose.androidcodingchallenge.commands

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sanchez.jose.androidcodingchallenge.networking.AbstractCommand
import sanchez.jose.androidcodingchallenge.networking.EbayClient

interface GetBooksForSaleListener {
    fun onGetBooksForSaleSuccess(response: List<BooksForSaleResponse>?)

    // Do we need to pass the error response to the presenter and handle it somehow?
    fun onGetBooksForSaleError()
}

class GetBooksForSaleCommand(private val listener: GetBooksForSaleListener?)
    : AbstractCommand(), Callback<List<BooksForSaleResponse>> {

    private val service = EbayClient.service.getBooksForSale()

    override fun execute() {
        service.enqueue(this)
    }

    override fun cancel() {
        service.cancel()
    }

    override fun onResponse(call: Call<List<BooksForSaleResponse>>, response: Response<List<BooksForSaleResponse>>
    ) {
        if (response.isSuccessful && response.body() != null) {
            listener?.onGetBooksForSaleSuccess(response.body())
        } else {
            listener?.onGetBooksForSaleError()
        }
    }

    override fun onFailure(call: Call<List<BooksForSaleResponse>>, t: Throwable) {
        // Should we pass the the throwable object to the presenter to see what happened?
        // maybe a generic Error object?
        listener?.onGetBooksForSaleError()
    }

}
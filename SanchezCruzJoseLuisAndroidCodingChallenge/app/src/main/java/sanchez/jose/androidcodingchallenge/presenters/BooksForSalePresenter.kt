package sanchez.jose.androidcodingchallenge.presenters

import androidx.annotation.VisibleForTesting
import sanchez.jose.androidcodingchallenge.models.BookViewModel
import sanchez.jose.androidcodingchallenge.controllers.BooksForSaleControllerInterface
import sanchez.jose.androidcodingchallenge.commands.BooksForSaleResponse

class BooksForSalePresenter(private val controller: BooksForSaleControllerInterface? = null) : BooksForSalePresenterInterface {

    override fun buildBooksForSaleViewModel(response: List<BooksForSaleResponse>?) {
        controller?.populateBooksForSale(buildBooksViewModel(response))
    }

    override fun buildOnErrorMessage() {
        controller?.displayErrorMessage()
    }

    @VisibleForTesting
    internal fun buildBooksViewModel(response: List<BooksForSaleResponse>?) : List<BookViewModel> {
        val booksViewModel = mutableListOf<BookViewModel>()
        response?.forEach {
            booksViewModel.add(createBookViewModel(it))
        }
        return booksViewModel
    }

    @VisibleForTesting
    internal fun createBookViewModel(book: BooksForSaleResponse): BookViewModel {
        val author = book.author?.let { "Author: $it" } ?: "" // we can also use translations for this. instead of hardcoding this in here.
        val title = book.title ?: ""
        val image = book.imageURL ?: ""
        return BookViewModel(title, image, author)
    }

}
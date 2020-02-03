package sanchez.jose.androidcodingchallenge

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import sanchez.jose.androidcodingchallenge.commands.BooksForSaleResponse
import sanchez.jose.androidcodingchallenge.presenters.BooksForSalePresenter

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BooksForSalePresenterTests {

    lateinit var presenter: BooksForSalePresenter

    @Before
    fun setup() {
        presenter = BooksForSalePresenter()
    }

    @Test
    fun `test if response is empty then return an empty list of book view models` () {
        val bookViewModels = presenter.buildBooksViewModel(null)
        assertTrue(bookViewModels.isEmpty())
    }

    @Test
    fun `test if response is NOT empty then return a NON empty list of book view models` () {
        // Creating a list of fake response. We can use some sort of mocking tool for this like Mockito or Mockk
        val book1 = BooksForSaleResponse(
            title = "Harry Potter",
            author = ""
        )
        val book2 =
            BooksForSaleResponse(title = "Harry Potter Year 1-7")
        val response = mutableListOf<BooksForSaleResponse>()
        response.apply {
            add(book1)
            add(book2)
        }

        val bookViewModels = presenter.buildBooksViewModel(response)

        assertTrue(bookViewModels.isNotEmpty())
        assertEquals(bookViewModels.size, response.size)
    }

    @Test
    fun `test if bookViewModel contains title from valid bookResponse object`() {
        val response =
            BooksForSaleResponse(title = "Harry Potter")
        val viewModel = presenter.createBookViewModel(response)

        assertEquals(response.title, viewModel.title)
    }

    @Test
    fun `test if bookViewModel contains author from valid bookResponse object`() {
        val response =
            BooksForSaleResponse(author = "J.K. Rowling")
        val viewModel = presenter.createBookViewModel(response)

        assertEquals("Author: J.K. Rowling", viewModel.author)
    }

    @Test
    fun `test if bookViewModel contains image from valid bookResponse object`() {
        val response =
            BooksForSaleResponse(imageURL = "http://google.com")
        val viewModel = presenter.createBookViewModel(response)

        assertEquals(response.imageURL, viewModel.image)
    }

    @Test
    fun `test if bookViewModel contains image as empty when imageURL is null`() {
        val response =
            BooksForSaleResponse(imageURL = null)
        val viewModel = presenter.createBookViewModel(response)

        assertTrue(viewModel.image.isEmpty())
    }

    @Test
    fun `test if bookViewModel contains author as empty when response author is null`() {
        val response =
            BooksForSaleResponse(author = null)
        val viewModel = presenter.createBookViewModel(response)

        assertTrue(viewModel.author.isEmpty())
    }

    @Test
    fun `test if bookViewModel contains title as empty when response title is null`() {
        val response =
            BooksForSaleResponse(title = null)
        val viewModel = presenter.createBookViewModel(response)

        assertTrue(viewModel.title.isEmpty())
    }

}

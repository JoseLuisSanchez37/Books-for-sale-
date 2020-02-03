package sanchez.jose.androidcodingchallenge.controllers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import sanchez.jose.androidcodingchallenge.models.BookViewModel
import sanchez.jose.androidcodingchallenge.R
import sanchez.jose.androidcodingchallenge.controllers.adapters.BooksForSaleAdapter
import sanchez.jose.androidcodingchallenge.interactors.BooksForSaleInteractor

class BooksForSaleController : AppCompatActivity(), BooksForSaleControllerInterface {

    private lateinit var interactor: BooksForSaleInteractor
    private val booksForSaleAdapter = BooksForSaleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initViews()

        interactor = BooksForSaleInteractor(this)
        interactor.getBooksForSaleOnEBay()

    }

    private fun initViews () {
        booksRecyclerView.apply {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@BooksForSaleController)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            setHasFixedSize(false)
            adapter = booksForSaleAdapter
        }
    }

    override fun populateBooksForSale(books: List<BookViewModel>) {
        booksForSaleAdapter.update(books)
        //dismiss Progress indicator
    }

    override fun displayErrorMessage() {
        // Fail silently for now just dismiss Progress indicator.
        // We can show a different layout maybe?
    }

}

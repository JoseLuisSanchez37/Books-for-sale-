package sanchez.jose.androidcodingchallenge.controllers

import sanchez.jose.androidcodingchallenge.models.BookViewModel

interface BooksForSaleControllerInterface {
    fun populateBooksForSale(books: List<BookViewModel>)
    fun displayErrorMessage()
}
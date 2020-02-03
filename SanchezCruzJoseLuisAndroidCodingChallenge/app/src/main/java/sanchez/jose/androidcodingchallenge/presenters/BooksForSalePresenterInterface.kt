package sanchez.jose.androidcodingchallenge.presenters

import sanchez.jose.androidcodingchallenge.commands.BooksForSaleResponse

interface BooksForSalePresenterInterface {
    fun buildBooksForSaleViewModel(response: List<BooksForSaleResponse>?)
    fun buildOnErrorMessage()
}
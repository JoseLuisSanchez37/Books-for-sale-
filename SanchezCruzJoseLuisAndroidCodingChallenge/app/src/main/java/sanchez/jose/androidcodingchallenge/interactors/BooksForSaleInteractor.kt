package sanchez.jose.androidcodingchallenge.interactors

import sanchez.jose.androidcodingchallenge.controllers.BooksForSaleControllerInterface
import sanchez.jose.androidcodingchallenge.commands.BooksForSaleResponse
import sanchez.jose.androidcodingchallenge.commands.GetBooksForSaleCommand
import sanchez.jose.androidcodingchallenge.commands.GetBooksForSaleListener
import sanchez.jose.androidcodingchallenge.presenters.BooksForSalePresenter

/**
 * Interactor - Entity from the Clean Architecture Pattern used to communicate the Controller(Activity, Fragment, View)
 * to the models or data sources (i.e Databases, web services, content providers, etc)
 * If there is some sort of business logic associated that them, that can be added here so that
 * is easy for testing without depending on android dependencies.
 * @param controller weak reference of the controller
 */
class BooksForSaleInteractor(controller: BooksForSaleControllerInterface?) :
    BooksForSaleInteractorInterface,
    GetBooksForSaleListener {

    private val presenter = BooksForSalePresenter(controller)

    override fun getBooksForSaleOnEBay() {
        val command = GetBooksForSaleCommand(this)
        command.execute()
    }

    override fun onGetBooksForSaleSuccess(response: List<BooksForSaleResponse>?) {
        presenter.buildBooksForSaleViewModel(response)
    }

    override fun onGetBooksForSaleError() {
        // notify to the presenter to build something for these type of scenarios
        // we can also send to the presenter what was sent from retrofit to the command
        // so there we can extract or get the reason and present a better understanding of the issue
        presenter.buildOnErrorMessage()
    }
}
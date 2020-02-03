package sanchez.jose.androidcodingchallenge.networking

/**
 * All the commands should extend from the abstract class
 */
abstract class AbstractCommand {
    /**
     * Function to fire the network request
     */
    abstract fun execute()

    /**
     * In case we need to cancel the request,
     * we can easily do it by calling this function
     */
    abstract fun cancel()
}
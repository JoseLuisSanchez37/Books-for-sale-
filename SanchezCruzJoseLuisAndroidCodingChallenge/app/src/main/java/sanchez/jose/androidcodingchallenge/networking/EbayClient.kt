package sanchez.jose.androidcodingchallenge.networking

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson


private const val BASE_URL = "https://de-coding-test.s3.amazonaws.com"

/**
 * Class that holds the retrofit class. Wrapping it up in an object class
 * since we just want a single instance of the client
 */
object EbayClient {

    /**
     * Creates an instance of Retrofit
     */
    private fun buildRetrofitClient() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

    val service: EbayService = buildRetrofitClient().create(EbayService::class.java)

}
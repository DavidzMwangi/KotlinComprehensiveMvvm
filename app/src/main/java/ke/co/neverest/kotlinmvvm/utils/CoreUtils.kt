package ke.co.neverest.kotlinmvvm.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import ke.co.neverest.kotlinmvvm.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors


class CoreUtils{


    companion object{
         var retrofit:Retrofit?=null
        var auth_retrofit:Retrofit?=null

        fun getRetrofitClient(): Retrofit? {
            if (retrofit == null) {
                val builder: Retrofit.Builder = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson()))
                    .callbackExecutor(Executors.newSingleThreadExecutor())
                val httpClient = OkHttpClient.Builder()
                val noCacheInterceptor = NoCacheInterceptor()
                httpClient.addInterceptor(noCacheInterceptor)
                builder.client(httpClient.build())
                retrofit = builder.build()
            }
            return retrofit
        }

       private fun gson(): Gson {
            return GsonBuilder()
                .serializeNulls()
                .create()
        }


        fun getAuthRetrofitClient(token: String?): Retrofit? {
            if (auth_retrofit == null) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                val builder: Retrofit.Builder = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson()))
                    .callbackExecutor(Executors.newSingleThreadExecutor())
                //build http interceptor with tokens
                val httpClient = OkHttpClient.Builder()
                val interceptor = AuthenticationInterceptor(token)
                val noCacheInterceptor = NoCacheInterceptor()
                httpClient.addInterceptor(interceptor)
                httpClient.addInterceptor(logging)
                httpClient.addInterceptor(noCacheInterceptor)
                builder.client(httpClient.build())
                auth_retrofit = builder.build()
            }
            return auth_retrofit
        }
    }

}
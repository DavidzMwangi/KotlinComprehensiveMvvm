package ke.co.neverest.kotlinmvvm.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthenticationInterceptor constructor(var token: String?) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {

        val original:Request=chain.request()

        val builder:Request.Builder= original.newBuilder().header("Authorization", "Bearer $token")
        val request=builder.build()

        return chain.proceed(request)
    }

}

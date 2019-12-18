package ke.co.neverest.kotlinmvvm.utils

import okhttp3.Interceptor
import okhttp3.Response

class NoCacheInterceptor : Interceptor {




    override fun intercept(chain: Interceptor.Chain): Response {

        var request=chain.request()
        val builder=request.newBuilder().addHeader("Cache-Control", "no-cache")
        request=builder.build()

        return chain.proceed(request)
    }

}

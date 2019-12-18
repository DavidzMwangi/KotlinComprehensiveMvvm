package ke.co.neverest.kotlinmvvm.services

import ke.co.neverest.kotlinmvvm.data.models.Authorization
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {

    @POST("login")
    @FormUrlEncoded
    fun attempLogin(@Field("username") username: String,@Field("password") password:String): Call<Authorization>
}
package ke.co.neverest.kotlinmvvm.repositories

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ke.co.neverest.kotlinmvvm.data.dao.AuthorizationDao
import ke.co.neverest.kotlinmvvm.data.models.Authorization
import ke.co.neverest.kotlinmvvm.services.AuthService
import ke.co.neverest.kotlinmvvm.utils.AppDatabase
import ke.co.neverest.kotlinmvvm.utils.CoreUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository   constructor(app:Application){
    private val appDatabase:AppDatabase = AppDatabase.invoke(app)
    private val authorizationDao:AuthorizationDao?=appDatabase.authorizationDao()


    fun getAuthorization(): LiveData<Authorization> {


        return authorizationDao!!.getAuthorization()
    }

    fun attemptLogin(username:String,password:String){
        val call:Call<Authorization> = CoreUtils.getRetrofitClient()?.create(AuthService::class.java)!!.attempLogin(username, password)
        call.enqueue(object : Callback<Authorization> {
            override fun onFailure(call: Call<Authorization>, t: Throwable) {
                Log.e("errere",t.message)
            }

            override fun onResponse(call: Call<Authorization>, response: Response<Authorization>) {

                if (response.isSuccessful){
                    authorizationDao?.insert(response.body()!!)

                }else{

                    Log.e("errere","error")

                }
            }


        })
    }
}
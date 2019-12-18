package ke.co.neverest.kotlinmvvm.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ke.co.neverest.kotlinmvvm.data.dao.AuthorizationDao
import ke.co.neverest.kotlinmvvm.data.models.Authorization
import ke.co.neverest.kotlinmvvm.utils.AppDatabase

class AuthRepository  constructor(private val app:Application){
    private val appDatabase:AppDatabase = AppDatabase.invoke(app)
    private val authorizationDao:AuthorizationDao?=appDatabase.authorizationDao()


    fun getAuthorization(): LiveData<Authorization> {


        return authorizationDao!!.getAuthorization()
    }
}
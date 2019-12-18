package ke.co.neverest.kotlinmvvm.ui.auth.views

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ke.co.neverest.kotlinmvvm.data.models.Authorization
import ke.co.neverest.kotlinmvvm.repositories.AuthRepository

class LoginFragmentViewModel(application: Application) :AndroidViewModel(application) {
   private val authorizationRepository:AuthRepository= AuthRepository(application)


  public  fun getAuthorization():LiveData<Authorization>{
        return authorizationRepository.getAuthorization()
    }

    fun attemptLogin(username:String, password:String){

        authorizationRepository.attemptLogin(username, password)
    }

}
package ke.co.neverest.kotlinmvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ke.co.neverest.kotlinmvvm.R
import ke.co.neverest.kotlinmvvm.ui.auth.fragments.LoginFragment
import ke.co.neverest.kotlinmvvm.ui.auth.fragments.WelcomeFragment

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        changeFragment(2)
    }

    fun changeFragment(page:Int){

        val fragmentTransaction=supportFragmentManager.beginTransaction()

        when(page){
            0,1->{
                fragmentTransaction.replace(R.id.auth_frame,WelcomeFragment(),"Welcome Fragment").commit()

            }
            2->{
                fragmentTransaction.replace(R.id.auth_frame,LoginFragment(),"Login Fragment").commit()
            }


        }

    }
}

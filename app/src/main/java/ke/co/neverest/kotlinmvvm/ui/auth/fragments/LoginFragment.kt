package ke.co.neverest.kotlinmvvm.ui.auth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ke.co.neverest.kotlinmvvm.R
import ke.co.neverest.kotlinmvvm.databinding.AuthLoginFragmentBinding
import ke.co.neverest.kotlinmvvm.ui.auth.views.LoginFragmentViewModel

class LoginFragment:Fragment() {
    private var loginFragmentViewModel:LoginFragmentViewModel?=null
    var binding:AuthLoginFragmentBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.auth_login_fragment, container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginFragmentViewModel=ViewModelProviders.of(this).get(LoginFragmentViewModel::class.java)


        loginFragmentViewModel?.getAuthorization()?.observe(this, Observer {
            if (it!=null){
                Toast.makeText(activity,"Not Null",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(activity," Null",Toast.LENGTH_SHORT).show()


            }
        })
        binding?.loginBtn?.setOnClickListener{
            //login here


        }
    }
}
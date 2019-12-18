package ke.co.neverest.kotlinmvvm.ui.auth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ke.co.neverest.kotlinmvvm.R
import ke.co.neverest.kotlinmvvm.databinding.AuthLoginFragmentBinding

class LoginFragment:Fragment() {

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


        binding?.loginBtn?.setOnClickListener{
            //login here



        }
    }
}
package com.emadomarah.fake_store_api.ui.auth

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.emadomarah.fake_store_api.R
import com.emadomarah.fake_store_api.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel:AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        binding.lifecycleOwner = this

        binding.loginButton.setOnClickListener {
            viewModel.registerUser("rr" , "TT")
            print("user added")
        }
    }


    fun validateUserData() :Boolean{
        if (binding.loginEmailET.text.isNullOrBlank() || binding.loginPasswordET.text.isNullOrBlank()){

            return false
        }

        return true
    }
}
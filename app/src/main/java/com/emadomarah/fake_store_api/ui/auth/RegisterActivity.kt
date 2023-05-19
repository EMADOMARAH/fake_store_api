package com.emadomarah.fake_store_api.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.emadomarah.fake_store_api.R
import com.emadomarah.fake_store_api.StoreApplication
import com.emadomarah.fake_store_api.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding:ActivityRegisterBinding

    private val viewModel:AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_register)
        binding.lifecycleOwner = this



        binding.registerButton.setOnClickListener {
            if (validateUserData()){
                viewModel.registerUser(
                    email = binding.registerEmailET.text.toString(),
                    password = binding.registerPasswordET.text.toString()
                )
                Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(this, "Data Not Valid", Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun validateUserData() :Boolean{
        if (binding.registerEmailET.text.isNullOrBlank() || binding.registerPasswordET.text.isNullOrBlank()){
            return false
        }
        return true
    }
}
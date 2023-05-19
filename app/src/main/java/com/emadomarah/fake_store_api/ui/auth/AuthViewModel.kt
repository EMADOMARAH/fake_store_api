package com.emadomarah.fake_store_api.ui.auth

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.emadomarah.domain.entity.db.User
import com.emadomarah.domain.repo.usecase.StoreUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel@Inject constructor(
    private val getStoreUseCases: StoreUseCases
): ViewModel() {

    lateinit var users : List<User>

    fun getUsersFromLocal(){
        viewModelScope.launch {
            Log.d("AuthViewModel" , getStoreUseCases.getUserFromLocal().toString())
        }
    }

    fun registerUser(
        email :String ,
        password : String,
    ){

        viewModelScope.launch {
            try {
                getStoreUseCases.insertUserToLocal(User(email = email , password = password))


            }catch (e:Exception){
                Log.d("Auth" , e.message.toString())
            }
        }
    }
}

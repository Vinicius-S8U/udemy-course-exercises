package com.example.contacts_manager.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts_manager.room.User
import com.example.contacts_manager.room.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(val repository: UserRepository) : ViewModel() {

    val users = repository.users
    val isUpdateOrDelete: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    lateinit var userToUpdateOrDelete: User

    fun insert(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }

    fun update(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(user)
    }

    fun delete(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(user)
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }


}
package com.example.contacts_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts_manager.databinding.ActivityMainBinding
import com.example.contacts_manager.room.User
import com.example.contacts_manager.room.UserDatabase
import com.example.contacts_manager.room.UserRepository
import com.example.contacts_manager.ui.RecyclerAdapter
import com.example.contacts_manager.viewModel.UserViewModel
import com.example.contacts_manager.viewModel.UserViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dao = UserDatabase.getInstance(application).userDAO
        val repository = UserRepository(dao)
        val factory = UserViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        setObservers()
        binding.mainRv.layoutManager = LinearLayoutManager(this)
        binding.mainCl.setOnClickListener {
            viewModel.isUpdateOrDelete.value = false
        }

    }

    private fun setObservers() {
        viewModel.isUpdateOrDelete.observe(this) {
            isUpdateOrDelete()
        }
        viewModel.users.observe(this) {
            binding.mainRv.adapter = RecyclerAdapter(viewModel.users.value!!, viewModel)
        }
    }

    private fun isUpdateOrDelete() {

        with(binding) {

            when (viewModel.isUpdateOrDelete.value) {
                true -> {
                    mainBtnClear.text = "Delete"
                    mainBtnClear.setOnClickListener {
                        viewModel.delete(viewModel.userToUpdateOrDelete)
                    }
                    mainBtnSave.text = "Update"
                    mainBtnSave.setOnClickListener {
                        val updatedUser = getUser()
                        viewModel.update(
                            User(
                                viewModel.userToUpdateOrDelete.id,
                                updatedUser.name,
                                updatedUser.email
                            )
                        )
                    }
                    setUser(viewModel.userToUpdateOrDelete)
                }

                false -> {
                    mainBtnClear.text = "Clear All"
                    mainBtnClear.setOnClickListener {
                        viewModel.deleteAll()
                    }
                    mainBtnSave.setOnClickListener {
                        val user = getUser()
                        viewModel.insert(user)
                    }
                    mainBtnSave.text = "Save"
                    clearIpt()
                }

                null -> {}
            }
        }
    }

    fun getUser(): User =
        User(0, binding.mainEtName.text.toString(), binding.mainEtEmail.text.toString())

    fun setUser(user: User) {
        binding.mainEtName.setText(user.name)
        binding.mainEtEmail.setText(user.email)
    }

    fun clearIpt() {
        binding.mainEtName.text.clear()
        binding.mainEtEmail.text.clear()
    }

}
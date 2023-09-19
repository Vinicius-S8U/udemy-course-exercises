package com.example.contacts_manager.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts_manager.databinding.CardItemBinding
import com.example.contacts_manager.room.User
import com.example.contacts_manager.viewModel.UserViewModel

class RecyclerAdapter(
    private val usersList: List<User>,
    val viewModel: UserViewModel
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CardItemBinding = CardItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding, viewModel)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(usersList[position],viewModel, viewModel.isUpdateOrDelete)
    }

}

class ViewHolder(val binding: CardItemBinding, viewModel: UserViewModel) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
        user: User,
        viewModel: UserViewModel,
        isUpdateOrDelete: MutableLiveData<Boolean>
    ) {
        with(binding) {
            mainItemTvName.text = user.name
            mainItemTvEmail.text = user.email

            mainLl.setOnClickListener {
                viewModel.userToUpdateOrDelete = User(
                    user.id,
                    user.name,
                    user.email
                )
                isUpdateOrDelete.value = true
            }

        }
    }
}
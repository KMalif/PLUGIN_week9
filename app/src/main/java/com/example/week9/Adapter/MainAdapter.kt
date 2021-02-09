package com.example.week9.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week9.Model.User
import com.example.week9.databinding.ItemUserBinding

class MainAdapter (var users : MutableList<User> = mutableListOf()):RecyclerView.Adapter<MainAdapter.UserViewHolder> (){

    inner class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
       return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.apply {
            tvId.text = users[position].getId().toString()
            tvNama.text = users[position].getNama()
            tvEmail.text = users[position].getEmail()
        }
    }
    fun setUser(data : List<User>){
        users.clear()
        users.addAll(data)
        notifyDataSetChanged()
    }
}
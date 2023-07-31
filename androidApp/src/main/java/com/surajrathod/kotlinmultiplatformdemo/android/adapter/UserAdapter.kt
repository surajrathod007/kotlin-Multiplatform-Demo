package com.surajrathod.kotlinmultiplatformdemo.android.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.surajrathod.kotlinmultiplatformdemo.android.databinding.UserItemLayoutBinding
import com.surajrathod.kotlinmultiplatformdemo.android.ui.activity.UserDetailsActivity
import com.surajrathod.kotlinmultiplatformdemo.model.UsersItem

class UserAdapter(val list: List<UsersItem> , val onClick : (UsersItem) -> Unit = {}) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(binding: UserItemLayoutBinding) : ViewHolder(binding.root) {
        val txtUserName = binding.txtUserName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            UserItemLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context,
                ), parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val i = list[position]
        holder.txtUserName.text = i.name
        holder.txtUserName.setOnClickListener {
            //TODO:Not working
//            val i = Intent(it.context,UserDetailsActivity::class.java)
//            i.putExtra("user",i)
//            it.context.startActivity(i)
            //it.context.startActivity(Intent(it.context,UserDetailsActivity::class.java))
            onClick.invoke(i)
        }
    }

}
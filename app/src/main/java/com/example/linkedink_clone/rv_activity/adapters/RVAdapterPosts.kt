package com.example.linkedink_clone.rv_activity.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.linkedink_clone.R
import com.example.linkedink_clone.data.Post

class RVAdapterPosts(private var posts: List<Post>) : RecyclerView.Adapter<RVAdapterPosts.PostViewHolder>() {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUserName: TextView = view.findViewById(R.id.tvUsername)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val postView = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_post, parent, false)
        return PostViewHolder(postView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.tvUserName.text = posts[position].userName
    }

    override fun getItemCount(): Int = posts.size

    @SuppressLint("NotifyDataSetChanged")
    fun updatePosts(newPosts: List<Post>) {
        posts = newPosts
        notifyDataSetChanged()
    }
}
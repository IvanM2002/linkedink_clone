package com.example.linkedink_clone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.linkedink_clone.rv_activity.RecyclerViewActivity
import com.example.linkedink_clone.R
import com.example.linkedink_clone.data.Post
import com.example.linkedink_clone.utils.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var llPosts: LinearLayout
    private val postList = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        fillPostList()
        addPostsToLL()
    }

    private fun fillPostList() {
        for (i in 0 until 10) {
            postList.add(Post("Username $i"))
        }
    }

    private fun addPostsToLL() {
        postList.forEach { post ->
            val postView = layoutInflater.inflate(R.layout.home_post, null)

            val tvUsername: TextView = postView.findViewById(R.id.tvUsername)
            tvUsername.text = post.userName

            val ibLike = postView.findViewById<ImageButton>(R.id.ibLike)
            ibLike.setOnClickListener {
                showToast("ibLike ${post.userName}")
            }

            postView.findViewById<ImageButton>(R.id.ibComment).setOnClickListener {
                showToast("ibComment ${post.userName}", Toast.LENGTH_LONG)
            }

            llPosts.addView(postView)
        }
    }

    private fun initViews() {
        llPosts = findViewById(R.id.ll_posts)
        findViewById<Button>(R.id.btn_rv).setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }
}
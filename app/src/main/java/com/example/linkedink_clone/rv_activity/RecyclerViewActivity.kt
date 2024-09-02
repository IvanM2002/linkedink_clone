package com.example.linkedink_clone.rv_activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.linkedink_clone.rv_activity.adapters.RVAdapterPosts
import com.example.linkedink_clone.R
import com.example.linkedink_clone.data.Post

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvPosts: RecyclerView
    private lateinit var rvAdapterPost: RVAdapterPosts
    private val postList = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        fillPostList()
        initViews()
    }

    private fun initViews() {
        rvPosts = findViewById(R.id.rv_posts)
        initRV()
    }

    private fun initRV() {
        rvAdapterPost = RVAdapterPosts(posts = postList)
        rvPosts.apply {
            layoutManager =
                LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = rvAdapterPost
        }
    }

    private fun fillPostList() {
        for (i in 0 until 10) {
            postList.add(Post("Username $i"))
        }
    }
}
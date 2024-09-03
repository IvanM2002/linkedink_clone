package com.example.linkedink_clone.rv_activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.linkedink_clone.R
import com.example.linkedink_clone.rv_activity.adapters.RVAdapterPosts
import com.example.linkedink_clone.view_model.RvViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvPosts: RecyclerView
    private lateinit var rvAdapterPost: RVAdapterPosts

    private val viewModel: RvViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initViews()
        observeViewModel()
    }

    private fun initViews() {
        rvPosts = findViewById(R.id.rv_posts)
        rvAdapterPost = RVAdapterPosts(posts = arrayListOf())
        rvPosts.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = rvAdapterPost
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                rvAdapterPost.updatePosts(state.posts)
            }
        }
    }
}
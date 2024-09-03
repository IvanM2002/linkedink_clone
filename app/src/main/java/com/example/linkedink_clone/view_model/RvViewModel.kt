package com.example.linkedink_clone.view_model

import androidx.lifecycle.ViewModel
import com.example.linkedink_clone.data.Post
import com.example.linkedink_clone.data.PostUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RvViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PostUIState())

    val uiState: StateFlow<PostUIState> = _uiState.asStateFlow()

    init {
        fillPostList()
    }

    private fun fillPostList() {
        val initialPosts = (0 until 10).map { i -> Post("Username $i") }
        _uiState.value = _uiState.value.copy(posts = initialPosts)
    }

    fun addPost(username: String) {
        _uiState.update { currentState ->
            val newPost = Post(username)
            currentState.copy(posts = currentState.posts + newPost)
        }
    }
}
package com.example.journal

import com.google.firebase.Timestamp


data class Journal(
    var userId: String,
    var username: String,
    var title: String,
    var thoughts: String,
    var imageUrl: String,
    val timeAdded: Timestamp
)

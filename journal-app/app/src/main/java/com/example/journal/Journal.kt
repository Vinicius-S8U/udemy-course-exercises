package com.example.journal

import java.sql.Timestamp

data class Journal(
    var userId: String,
    var username: String,
    var title: String,
    var thoughts: String,
    var imageUrl: String,
    val timeAdded: Timestamp
)

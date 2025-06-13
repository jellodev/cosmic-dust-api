package com.project.domain

data class Journal(
    val id: String,
    val content: JournalContent,
    val createdAt: Long = System.currentTimeMillis(),
)

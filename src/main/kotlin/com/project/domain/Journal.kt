package com.project.domain

data class Journal(
    val id: Long,
    val components: List<JournalComponent>,
    val createdAt: Long = System.currentTimeMillis(),
)

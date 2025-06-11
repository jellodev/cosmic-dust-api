package com.project.domain

sealed class JournalComponent {
    abstract fun saveContent()
    abstract fun getContent()
}

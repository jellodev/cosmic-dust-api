package com.project.domain

data class ImageComponent(val imageUrl: String) : JournalComponent() {
    override fun saveContent() { /* ... */ }
    override fun getContent() { /* ... */ }
}
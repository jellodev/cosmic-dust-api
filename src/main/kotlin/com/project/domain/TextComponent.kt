package com.project.domain

data class TextComponent(val text: String) : JournalComponent() {
    override fun saveContent() { /* ... */ }
    override fun getContent() { /* ... */ }
}
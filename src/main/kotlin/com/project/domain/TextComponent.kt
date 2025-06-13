package com.project.domain

data class TextComponent(
    val content: String,
) : JournalComponent {
    override val type = "text"
}

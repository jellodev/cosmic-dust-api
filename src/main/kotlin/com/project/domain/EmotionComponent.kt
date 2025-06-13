package com.project.domain

data class EmotionComponent(val selectedEmotion: String) : JournalComponent {
    override val type = "emotion"
}

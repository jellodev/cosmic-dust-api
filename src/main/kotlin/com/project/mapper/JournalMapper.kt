package com.project.mapper

import com.project.domain.EmotionComponent
import com.project.domain.JournalComponent
import com.project.domain.TextComponent
import com.project.dto.EmotionComponentRequest
import com.project.dto.JournalComponentRequest
import com.project.dto.TextComponentRequest

object JournalMapper {
    fun toDomainComponents(components: List<JournalComponentRequest>): List<JournalComponent> {
        return components.map {
            when (it) {
                is TextComponentRequest -> TextComponent(it.text)
                is EmotionComponentRequest -> EmotionComponent(it.emotion)
                else -> throw IllegalArgumentException("Unknown component type: $it")
            }
        }
    }
}

package com.project.service

import com.project.domain.JournalComponent
import com.project.domain.JournalComponentProcessorStrategy
import com.project.domain.TextComponent
import org.springframework.stereotype.Component

@Component
class TextComponentStrategy : JournalComponentProcessorStrategy {
    override fun supports(content: JournalComponent): Boolean = content is TextComponent

    override fun process(content: JournalComponent): JournalComponent =
        (content as TextComponent).copy(
            content = content.content.trim(),
        )
}

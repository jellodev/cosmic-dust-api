package com.project.service

import com.project.domain.JournalContent
import com.project.domain.JournalContentProcessorStrategy
import com.project.domain.TextContent
import org.springframework.stereotype.Component

@Component
class TextContentStrategy : JournalContentProcessorStrategy {
    override fun supports(content: JournalContent): Boolean = content is TextContent

    override fun process(content: JournalContent): JournalContent =
        (content as TextContent).copy(
            content = content.content.trim(),
        )
}

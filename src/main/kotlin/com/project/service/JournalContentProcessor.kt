package com.project.service

import com.project.domain.JournalContent
import com.project.domain.JournalContentProcessorStrategy
import org.springframework.stereotype.Service

@Service
class JournalContentProcessor(
    private val strategies: List<JournalContentProcessorStrategy>,
) {
    fun processContent(content: JournalContent): JournalContent =
        strategies
            .find { it.supports(content) }
            ?.process(content)
            ?: content
}

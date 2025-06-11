package com.project.service

import com.project.domain.JournalComponent
import com.project.domain.JournalComponentProcessorStrategy
import org.springframework.stereotype.Service

@Service
class JournalContentProcessor(
    private val strategies: List<JournalComponentProcessorStrategy>
) {
    fun processComponents(components: List<JournalComponent>): List<JournalComponent> {
        return components.map { component ->
            strategies.find { it.supports(component) }
                ?.process(component)
                ?: component
        }
    }
}
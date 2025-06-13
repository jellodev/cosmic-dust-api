package com.project.service

import com.project.domain.JournalComponent
import com.project.domain.JournalComponentProcessorStrategy
import org.springframework.stereotype.Service

@Service
class JournalComponentProcessor(
    private val strategies: List<JournalComponentProcessorStrategy>,
) {
    fun processComponent(components: List<JournalComponent>): List<JournalComponent> {
        return components.map { component ->
            strategies.find { it.supports(component) }
                ?.process(component)
                ?: component
        }
    }
}

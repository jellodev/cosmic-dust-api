package com.project.service

import com.project.domain.ImageComponent
import com.project.domain.JournalComponent
import com.project.domain.JournalComponentProcessorStrategy
import org.springframework.stereotype.Component

@Component
class ImageComponentStrategy(
    private val imageStorageService: ImageStorageService
) : JournalComponentProcessorStrategy {
    override fun supports(component: JournalComponent): Boolean {
        return component is ImageComponent
    }

    override fun process(component: JournalComponent): JournalComponent {
        // todo image save
        return component
    }
}
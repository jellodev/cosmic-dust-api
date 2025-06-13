package com.project.domain

interface JournalContentProcessorStrategy {
    fun supports(content: JournalContent): Boolean

    fun process(content: JournalContent): JournalContent
}

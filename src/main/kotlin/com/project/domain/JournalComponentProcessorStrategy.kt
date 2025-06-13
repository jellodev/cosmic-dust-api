package com.project.domain

interface JournalComponentProcessorStrategy {
    fun supports(content: JournalComponent): Boolean

    fun process(content: JournalComponent): JournalComponent
}

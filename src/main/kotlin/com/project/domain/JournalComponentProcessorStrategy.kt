package com.project.domain

interface JournalComponentProcessorStrategy {
    fun supports(component: JournalComponent): Boolean
    fun process(component: JournalComponent): JournalComponent
}
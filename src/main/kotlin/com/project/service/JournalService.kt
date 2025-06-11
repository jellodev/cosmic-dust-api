package com.project.service

import org.springframework.stereotype.Service

import com.project.domain.Journal
import com.project.domain.JournalComponent
import com.project.repository.InMemoryJournalRepository

import java.util.UUID

@Service
class JournalService(
    private val journalRepository: InMemoryJournalRepository,
    private val journalContentProcessor: JournalContentProcessor
) {
    // 일기 생성
    fun createJournal(title: String, components: List<JournalComponent>): Journal {
        val processedComponents = journalContentProcessor.processComponents(components)

        val newJournal = Journal(
            id = UUID.randomUUID().toString(), // ID 생성 로직
            title = title,
            components = processedComponents,
            createdAt = System.currentTimeMillis()
        )
        return journalRepository.save(newJournal)
    }

    // 일기 조회
    fun getJournalById(id: String): Journal? {
        return journalRepository.findById(id)
    }

    // 일기 수정
    fun updateJournal(id: String, title: String?, components: List<JournalComponent>?): Journal? {
        val existingJournal = journalRepository.findById(id) ?: return null

        val updatedJournal = existingJournal.copy(
            title = title ?: existingJournal.title,
            components = components?.let { journalContentProcessor.processComponents(it) } ?: existingJournal.components,
            updatedAt = System.currentTimeMillis()
        )
        return journalRepository.save(updatedJournal)
    }
}
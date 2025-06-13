package com.project.service

import com.project.domain.Journal
import com.project.domain.TextContent
import com.project.dto.CreateJournalRequest
import com.project.mapper.JournalMapper
import com.project.repository.InMemoryJournalRepository
import org.springframework.stereotype.Service

@Service
class JournalService(
    private val journalRepository: InMemoryJournalRepository,
    private val journalContentProcessor: JournalContentProcessor,
) {
    fun createJournal(request: CreateJournalRequest): Journal {
        val processedContent = journalContentProcessor.processContent(TextContent(request.content))
        val journal = JournalMapper.toDomain(processedContent)
        return journalRepository.save(journal)
    }
}

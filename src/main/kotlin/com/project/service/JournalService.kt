package com.project.service

import com.project.domain.Journal
import com.project.domain.JournalComponent
import com.project.dto.CreateJournalRequest
import com.project.dto.common.EntityList
import com.project.mapper.JournalMapper
import com.project.repository.InMemoryJournalRepository
import org.springframework.stereotype.Service

@Service
class JournalService(
    private val journalRepository: InMemoryJournalRepository,
    private val journalComponentProcessor: JournalComponentProcessor,
) {
    fun createJournal(request: CreateJournalRequest): Journal {
        val rawComponents: List<JournalComponent> = JournalMapper.toDomainComponents(request.components)
        val processedComponents: List<JournalComponent> = journalComponentProcessor.processComponent(rawComponents)

        val journal =
            Journal(
                id = generateId(),
                components = processedComponents,
            )
        return journalRepository.save(journal)
    }

    fun getJournalById(id: Long): Journal {
        journalRepository.findByIdOrNull(id)?.let { return it }
        throw NoSuchElementException("No journal found with ID $id")
    }

    fun getJournals(
        cursor: Long?,
        limit: Int,
    ): EntityList<Journal> {
        val journals = journalRepository.findByCursorAfter(cursor, limit + 1)

        val hasNext = journals.size > limit
        val items = if (hasNext) journals.dropLast(1) else journals
        val lastCursor = items.lastOrNull()?.id

        return EntityList(
            hasNext = hasNext,
            lastCursor = lastCursor,
            items = items.map { it },
        )
    }

    private fun generateId(): Long = System.currentTimeMillis()
}

package com.project.repository

import com.project.domain.Journal
import org.springframework.stereotype.Repository

@Repository
class InMemoryJournalRepository : JournalRepository {
    private val journals = mutableMapOf<String, Journal>() // 임시 저장소 (메모리)

    override fun save(journal: Journal): Journal {
        journals[journal.id] = journal
        return journal
    }
}

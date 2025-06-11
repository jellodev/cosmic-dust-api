package com.project.repository

import com.project.domain.Journal
import org.springframework.stereotype.Repository

@Repository
class InMemoryJournalRepository : JournalRepository {
    private val journals = mutableMapOf<String, Journal>() // 임시 저장소 (메모리)

    override fun save(journal: Journal): Journal {
        journals[journal.id] = journal // id는 Journal 도메인 객체에 있어야 함
        return journal
    }

    override fun findById(id: String): Journal? {
        return journals[id]
    }

    override fun findAll(): List<Journal> {
        return journals.values.toList()
    }
}
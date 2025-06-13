package com.project.repository

import com.project.domain.Journal
import org.springframework.stereotype.Repository

@Repository
class InMemoryJournalRepository : JournalRepository {
    private val journals = mutableMapOf<Long, Journal>() // 임시 저장소 (메모리)

    override fun save(journal: Journal): Journal {
        journals[journal.id] = journal
        return journal
    }

    override fun findByIdOrNull(id: Long): Journal? {
        journals[id]?.let { return it }
        return null
    }

    override fun findByCursorAfter(
        cursor: Long?,
        limit: Int,
    ): List<Journal> {
        val filtered =
            if (cursor == null) {
                journals.values
            } else {
                journals.values.filter { it.id > cursor }
            }
        return filtered.take(limit)
    }
}

package com.project.repository

import com.project.domain.Journal

interface JournalRepository {
    fun save(journal: Journal): Journal

    fun findByIdOrNull(id: Long): Journal?

    fun findByCursorAfter(
        cursor: Long?,
        limit: Int,
    ): List<Journal>
}

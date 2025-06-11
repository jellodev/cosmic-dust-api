package com.project.repository

import com.project.domain.Journal

interface JournalRepository {
    fun save(journal: Journal): Journal
    fun findById(id: String): Journal?
    fun findAll(): List<Journal>
}
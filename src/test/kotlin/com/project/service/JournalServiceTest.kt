package com.project.service

import com.project.domain.Journal
import com.project.domain.TextComponent
import com.project.repository.InMemoryJournalRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.util.UUID

class JournalServiceTest : FunSpec({

    val journalRepository = mockk<InMemoryJournalRepository>()
    val journalContentProcessor = mockk<JournalContentProcessor>()

    val journalService = JournalService(journalRepository, journalContentProcessor)

    val journalId = UUID.randomUUID().toString()
    val components = listOf(TextComponent(" text "));
    val processedComponents = listOf(TextComponent("text"));
    val journal = Journal(
        id = journalId,
        title = "My Title",
        components = listOf(TextComponent("text")),
        createdAt = System.currentTimeMillis()
    )

    beforeEach {
        clearAllMocks()
    }

    test("") {
        every { journalContentProcessor.processComponents(components) } returns processedComponents
        every { journalRepository.save(any()) } returns journal

        val result = journalService.createJournal("My Title", components)

        result.title shouldBe "My Title"
        result.components shouldBe processedComponents

        verify { journalContentProcessor.processComponents(components) }
        verify { journalRepository.save(any()) }
    }

    test("getJournalById") { }

    test("updateJournal") { }
})

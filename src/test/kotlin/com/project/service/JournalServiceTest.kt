package com.project.service

import com.project.domain.TextContent
import com.project.dto.CreateJournalRequest
import com.project.repository.InMemoryJournalRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk

class JournalServiceTest :
    FunSpec({

        val journalRepository = mockk<InMemoryJournalRepository>()
        val journalContentProcessor = mockk<JournalContentProcessor>()
        val journalService = JournalService(journalRepository, journalContentProcessor)

        beforeEach {
            clearAllMocks()
        }

        test("should create text journal") {
            every { journalContentProcessor.processContent(any()) } returns (TextContent("processed"))
            every { journalRepository.save(any()) } answers { firstArg() }

            val createJournalRequest = CreateJournalRequest("Raw")
            val journal = journalService.createJournal(createJournalRequest)

            journal.content shouldBe TextContent("processed")
        }
    })

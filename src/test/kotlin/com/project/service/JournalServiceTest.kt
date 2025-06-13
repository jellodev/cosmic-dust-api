package com.project.service

import com.project.domain.EmotionComponent
import com.project.domain.Journal
import com.project.domain.TextComponent
import com.project.dto.CreateJournalRequest
import com.project.dto.EmotionComponentRequest
import com.project.dto.TextComponentRequest
import com.project.repository.InMemoryJournalRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk

class JournalServiceTest :
    FunSpec({

        val journalRepository = mockk<InMemoryJournalRepository>()
        val journalComponentProcessor = mockk<JournalComponentProcessor>()
        val journalService = JournalService(journalRepository, journalComponentProcessor)
        val components = listOf(TextComponent("hello"), EmotionComponent("\uD83E\uDD13"))

        beforeEach {
            clearAllMocks()
        }

        test("should create journal") {
            val componentRequests = listOf(TextComponentRequest(" hello "), EmotionComponentRequest("\uD83E\uDD13"))

            every { journalComponentProcessor.processComponent(any()) } returns (components)
            every { journalRepository.save(any()) } answers { firstArg() }

            val createJournalRequest = CreateJournalRequest(componentRequests)
            val journal = journalService.createJournal(createJournalRequest)

            journal.components shouldBe components
        }

        test("should get journal by id") {
            val journalId = 1L
            val expectedJournal = Journal(id = journalId, components = components)

            every { journalRepository.findByIdOrNull(journalId) } returns expectedJournal

            val journal = journalService.getJournalById(journalId)

            journal shouldBe expectedJournal
        }

        test("should get journals") {

        }
    })

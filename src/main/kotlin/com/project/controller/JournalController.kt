package com.project.controller

import com.project.domain.Journal
import com.project.dto.CreateJournalRequest
import com.project.dto.common.ApiResponse
import com.project.dto.common.SingleEntity
import com.project.service.JournalService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/journal")
class JournalController(
    private val journalService: JournalService,
) {
    @PostMapping()
    fun create(
        @RequestBody request: CreateJournalRequest,
    ): ApiResponse<SingleEntity<Journal>> {
        val journal = journalService.createJournal(request)
        return ApiResponse(
            entityType = "journal",
            entityBody = SingleEntity(journal),
        )
    }
}

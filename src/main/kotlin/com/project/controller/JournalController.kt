package com.project.controller

import com.project.domain.Journal
import com.project.dto.CreateJournalRequest
import com.project.dto.common.ApiResponse
import com.project.dto.common.EntityList
import com.project.dto.common.SingleEntity
import com.project.service.JournalService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping()
class JournalController(
    private val journalService: JournalService,
) {
    @PostMapping("journal")
    fun create(
        @RequestBody request: CreateJournalRequest,
    ): ApiResponse<SingleEntity<Journal>> {
        val journal = journalService.createJournal(request)
        return ApiResponse(
            entityType = "journal",
            entityBody = SingleEntity(journal),
        )
    }

    @GetMapping("journal/{id}")
    fun getById(
        @PathVariable id: Long,
    ): ApiResponse<SingleEntity<Journal?>> {
        val journal = journalService.getJournalById(id)
        return ApiResponse(
            entityType = "journal",
            entityBody = SingleEntity(journal),
        )
    }

    @GetMapping("journals")
    fun getAll(
        @RequestParam(required = false) cursor: Long?,
        @RequestParam(defaultValue = "20") limit: Int,
    ): ResponseEntity<EntityList<Journal>> {
        val result = journalService.getJournals(cursor, limit)
        return ResponseEntity.ok(result)
    }
}

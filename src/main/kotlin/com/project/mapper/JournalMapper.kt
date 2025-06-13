package com.project.mapper

import com.project.domain.Journal
import com.project.domain.JournalContent
import java.util.UUID

object JournalMapper {
    fun toDomain(content: JournalContent): Journal =
        Journal(
            id = UUID.randomUUID().toString(),
            content = content,
        )
}

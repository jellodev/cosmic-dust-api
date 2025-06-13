package com.project.dto.common

import java.util.UUID

data class ApiResponse<T : EntityBody>(
    val version: String = "2025-06-13",
    val traceId: String = UUID.randomUUID().toString(),
    val entityType: String,
    val entityBody: T,
)

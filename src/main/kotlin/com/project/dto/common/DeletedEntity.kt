package com.project.dto.common

data class DeletedEntity(
    val id: String,
    val refId: String?,
) : EntityBody

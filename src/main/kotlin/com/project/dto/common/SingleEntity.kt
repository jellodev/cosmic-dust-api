package com.project.dto.common

data class SingleEntity<T>(
    val data: T,
) : EntityBody

package com.project.domain

import java.util.UUID

data class Journal(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val components: List<JournalComponent>,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long? = null
) {
    fun addComponent(component: JournalComponent): Journal {
        return this.copy(components = this.components + component, updatedAt = System.currentTimeMillis())
    }

    fun setComponents(newComponents: List<JournalComponent>): Journal {
        return this.copy(components = newComponents, updatedAt = System.currentTimeMillis())
    }
}
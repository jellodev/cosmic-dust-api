package com.project.dto

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    JsonSubTypes.Type(value = TextComponentRequest::class, name = "text"),
    JsonSubTypes.Type(value = EmotionComponentRequest::class, name = "emotion"),
)
interface JournalComponentRequest

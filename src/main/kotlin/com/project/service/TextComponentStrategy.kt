package com.project.service

import com.project.domain.JournalComponent
import com.project.domain.JournalComponentProcessorStrategy
import com.project.domain.TextComponent
import org.springframework.stereotype.Component

@Component
class TextComponentStrategy : JournalComponentProcessorStrategy {
    override fun supports(component: JournalComponent): Boolean {
        return component is TextComponent
    }

    override fun process(component: JournalComponent): JournalComponent {
        // 텍스트 내용에 대한 유효성 검사, 길이 제한, 특정 키워드 필터링 등의 로직
        return (component as TextComponent).copy(text = component.text.trim())
    }
}
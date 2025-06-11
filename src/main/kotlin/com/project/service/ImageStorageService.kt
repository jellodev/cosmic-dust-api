package com.project.service

import org.springframework.stereotype.Service
import java.io.File
import java.util.Base64
import java.util.UUID

@Service
class ImageStorageService {
    fun saveImage(base64ImageData: String?): String? {
        if (base64ImageData.isNullOrBlank()) return null

        val decodedBytes = Base64.getDecoder().decode(base64ImageData)
        val fileName = "${UUID.randomUUID()}.png" // 실제 확장자 판단 로직 필요
        val storagePath = "./uploads/$fileName" // 실제 저장 경로

        try {
            val file = File(storagePath)
            file.parentFile.mkdirs()
            file.writeBytes(decodedBytes)
            println("Image saved to: $storagePath")
        } catch (e: Exception) {
            println("Error saving image: ${e.message}")
            return null
        }

        return "/images/$fileName"
    }

}
package com.pmdm.ecobite.data.room.mensaje

import androidx.room.TypeConverter
import java.time.LocalDateTime

class Converters {
    // Convierte LocalDateTime a Long (timestamp)
    @TypeConverter
    fun fromLocalDateTime(date: LocalDateTime?): Long? {
        return date?.atZone(java.time.ZoneId.systemDefault())?.toInstant()?.toEpochMilli()
    }

    // Convierte Long (timestamp) a LocalDateTime
    @TypeConverter
    fun toLocalDateTime(timestamp: Long?): LocalDateTime? {
        return timestamp?.let {
            LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(it), java.time.ZoneId.systemDefault())
        }
    }
}
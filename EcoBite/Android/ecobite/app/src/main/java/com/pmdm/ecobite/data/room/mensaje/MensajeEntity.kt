package com.pmdm.ecobite.data.room.mensaje

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "mensajes")
data class MensajeEntity (
    @PrimaryKey(autoGenerate = true)
    val idMensaje: Int,
    val idRemitente: Int,
    val contenido: String,
    val fechaEnvio: LocalDateTime
)
package com.pmdm.ecobite.models// ===================== CLASE Mensaje =====================
import java.time.LocalDateTime

data class Mensaje(
    val idMensaje: Int,
    val idRemitente: Int,
    val contenido: String,
    val fechaEnvio: LocalDateTime
)

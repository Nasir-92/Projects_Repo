// data/mock/mensaje/MensajeMock.kt
import java.time.LocalDateTime

data class MensajeMock(
    val idMensaje: Int,
    val idRemitente: Int,
    val contenido: String,
    val fechaEnvio: LocalDateTime
)

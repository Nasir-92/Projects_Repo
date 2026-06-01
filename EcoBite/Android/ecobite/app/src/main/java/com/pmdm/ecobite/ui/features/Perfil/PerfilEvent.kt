package com.pmdm.ecobite.ui.features.perfil

sealed interface PerfilEvent {

    data class OnCambiarNombre(val texto: String) : PerfilEvent

    data class OnCambiarEmail(val texto: String) : PerfilEvent

    data class OnCambiarUbicacion(val texto: String) : PerfilEvent

    object OnClickGuardarPerfil : PerfilEvent

    object OnClickCambiarContrasena : PerfilEvent

    object OnClickSoporte : PerfilEvent

    object OnClickVolver : PerfilEvent
}


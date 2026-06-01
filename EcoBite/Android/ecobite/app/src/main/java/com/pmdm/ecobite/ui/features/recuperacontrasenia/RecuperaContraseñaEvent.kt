package com.pmdm.ecobite.ui.features.recuperacontrasenia

sealed interface RecuperarContraseniaEvent {

    data class OnEmailChanged(val email: String) : RecuperarContraseniaEvent

    data class OnNuevaContraseñaChanged(val contrasenia: String) : RecuperarContraseniaEvent

    data class OnConfirmarContraseñaChanged(val contrasenia: String) : RecuperarContraseniaEvent

    object OnCambiarContraseñaClick : RecuperarContraseniaEvent

    object OnVolverLoginClick : RecuperarContraseniaEvent
    object OnBackClikced: RecuperarContraseniaEvent
}
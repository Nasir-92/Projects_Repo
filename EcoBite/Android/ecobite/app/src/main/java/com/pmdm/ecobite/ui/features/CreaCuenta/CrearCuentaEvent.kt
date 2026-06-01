package com.pmdm.ecobite.ui.features.creacuenta

import com.pmdm.ecobite.ui.features.receta.RecetaEvent

sealed interface CrearCuentaEvent {

    data class OnNombreChanged(val nombre: String) : CrearCuentaEvent

    data class OnApellidosChanged(val apellidos: String) : CrearCuentaEvent

    data class OnTelefonoChanged(val telefono: String) : CrearCuentaEvent

    data class OnEmailChanged(val email: String) : CrearCuentaEvent

    data class OnPasswordChanged(val password: String) : CrearCuentaEvent

    data class OnRepetirPasswordChanged(val repetirPassword: String) : CrearCuentaEvent

    object OnConfirmarClick : CrearCuentaEvent

    object OnCancelarClick : CrearCuentaEvent

    object OnBackClicked : CrearCuentaEvent
}
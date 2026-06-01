package com.pmdm.ecobite.ui.features.login

sealed interface LoginEvent {

    data class OnEmailChanged(val email: String) : LoginEvent

    data class OnPasswordChanged(val password: String) : LoginEvent

    object OnLoginClick : LoginEvent

    object OnCreateAccountClick : LoginEvent

    object OnRecoverPasswordClick : LoginEvent
}
package com.pmdm.ecobite.ui.features.creacuenta

data class CrearCuentaUiState(

    val nombre: String = "",

    val apellidos: String = "",

    val telefono: String = "",

    val email: String = "",

    val password: String = "",

    val repetirPassword: String = "",

    val errorMessage: String? = null,

    val isLoading: Boolean = false
)
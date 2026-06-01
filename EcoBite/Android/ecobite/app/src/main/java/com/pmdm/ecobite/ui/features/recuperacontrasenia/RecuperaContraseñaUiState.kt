package com.pmdm.ecobite.ui.features.recuperacontrasenia

data class RecuperarContraseniaUiState(

    val email: String = "",

    val nuevaPassword: String = "",

    val confirmarPassword: String = "",

    val errorMessage: String? = null,

    val mensajeExito: String? = null,

    val isLoading: Boolean = false
)
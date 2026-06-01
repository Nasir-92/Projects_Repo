package com.pmdm.ecobite.ui.features.perfil

data class PerfilUiState(

    val nombre: String = "",

    val email: String = "",

    val ubicacion: String = "",

    val isLoading: Boolean = false,

    val errorMessage: String? = null
)
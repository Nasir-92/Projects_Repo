package com.pmdm.ecobite.ui.features.login

data class LoginUiState(

    val email: String = "",

    val password: String = "",

    val errorMessage: String? = null,

    val loginCorrecto: Boolean = false
)

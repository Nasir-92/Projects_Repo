
package com.pmdm.ecobite.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.ecobite.ui.features.login.LoginEvent
import com.pmdm.ecobite.ui.features.login.LoginScreen
import com.pmdm.ecobite.ui.features.login.LoginViewModel

fun NavGraphBuilder.loginDestination(
    vm: LoginViewModel,
    onLoginSuccess: () -> Unit,
    onNavigateCrearCuenta: () -> Unit,
    onNavigateRecuperarPassword: () -> Unit
) {

    composable<LoginRoute> {

        LoginScreen(
            loginUiState = vm.uiState.value,
            onLoginEvent = { event ->

                when(event){

                    LoginEvent.OnLoginClick -> {
                        vm.onEvent(event)
                        onLoginSuccess()
                    }

                    LoginEvent.OnCreateAccountClick -> {
                        onNavigateCrearCuenta()
                    }

                    LoginEvent.OnRecoverPasswordClick -> {
                        onNavigateRecuperarPassword()
                    }

                    else -> {
                        vm.onEvent(event)
                    }
                }
            }
        )
    }
}

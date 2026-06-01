package com.pmdm.ecobite.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.ecobite.ui.features.recuperacontrasenia.RecuperarContraseniaScreen
import com.pmdm.ecobite.ui.features.recuperacontrasenia.RecuperarContraseñaViewModel

fun NavGraphBuilder.recuperarContraseniaDestination(

    vm: RecuperarContraseñaViewModel,

    onBack: () -> Unit,

    onNavigateLogin: () -> Unit

) {

    composable<RecuperarContraseniaRoute> {

        RecuperarContraseniaScreen(

            uiState = vm.uiState.value,

            onEvent = vm::onEvent,

            onBack = {

                onBack()
            }
        )
    }
}
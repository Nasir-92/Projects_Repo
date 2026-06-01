
package com.pmdm.ecobite.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.ecobite.ui.features.perfil.PerfilScreen
import com.pmdm.ecobite.ui.features.perfil.PerfilViewModel

fun NavGraphBuilder.perfilDestination(
    vm: PerfilViewModel,
    onBack: () -> Unit
) {

    composable<PerfilRoute> {

        PerfilScreen(
            uiState = vm.uiState.value,
            onEvent = vm::onEvent
        )
    }
}

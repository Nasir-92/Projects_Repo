package com.pmdm.ecobite.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.ecobite.ui.features.inicio.InicioScreen
import com.pmdm.ecobite.ui.features.inicio.InicioViewModel

fun NavGraphBuilder.inicioDestination(
    vm: InicioViewModel,
    onNavigateRestaurante: (Int) -> Unit,
    onNavigateReceta: (Int) -> Unit,
    onNavigatePerfil: () -> Unit
) {

    composable<InicioRoute> {

        InicioScreen(

            uiState = vm.uiState.value,

            onEvent = vm::onEvent,

            onClickRestaurante = {
                onNavigateRestaurante(it)
            },

            onClickReceta = {
                onNavigateReceta(it)
            },

            onClickPerfil = {
                onNavigatePerfil()
            }
        )
    }
}
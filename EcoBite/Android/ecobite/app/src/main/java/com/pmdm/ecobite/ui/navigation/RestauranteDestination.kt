
package com.pmdm.ecobite.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.pmdm.ecobite.ui.features.restaurante.RestauranteViewModel
import com.pmdm.ecobite.ui.features.restaurante.RestauranteScreen

fun NavGraphBuilder.restauranteDestination(
    vm: RestauranteViewModel,
    onNavigateReceta: (Int) -> Unit,
    onBack: () -> Unit
) {

    composable<RestauranteRoute> { backStackEntry ->

        val route = backStackEntry.toRoute<RestauranteRoute>()

        vm.setRestaurante(route.idRestaurante)

        RestauranteScreen(
            uiState = vm.uiState.value,
            onEvent = vm::onEvent,
            onClickReceta = {
                onNavigateReceta(it)
            },
            onBack = onBack
        )
    }
}

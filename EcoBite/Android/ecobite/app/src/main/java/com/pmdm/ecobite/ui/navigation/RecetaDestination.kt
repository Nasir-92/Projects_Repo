
package com.pmdm.ecobite.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.pmdm.ecobite.ui.features.receta.RecetaViewModel
import com.pmdm.ecobite.ui.features.receta.RecetaScreen

fun NavGraphBuilder.recetaDestination(
    vm: RecetaViewModel,
    onNavigateRestaurante: (Int) -> Unit,
    onBack: () -> Unit
) {

    composable<RecetaRoute> { backStackEntry ->

        val route = backStackEntry.toRoute<RecetaRoute>()

        vm.setReceta(route.idReceta)

        RecetaScreen(
            uiState = vm.uiState.value,
            onEvent = vm::onEvent,
            onBack = onBack,
            onClickRestaurante = {
                onNavigateRestaurante(it)
            }
        )
    }
}

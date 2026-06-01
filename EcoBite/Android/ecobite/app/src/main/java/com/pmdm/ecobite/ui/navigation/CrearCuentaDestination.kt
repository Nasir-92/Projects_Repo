package com.pmdm.ecobite.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.ecobite.ui.features.creacuenta.CrearCuentaScreen
import com.pmdm.ecobite.ui.features.creacuenta.CrearCuentaViewModel

fun NavGraphBuilder.crearCuentaDestination(

    vm: CrearCuentaViewModel,

    onBack: () -> Unit,

    onNavigateLogin: () -> Unit

) {

    composable<CrearCuentaRoute> {

        CrearCuentaScreen(

            viewModel = vm,

            onBack = {

                onBack()
            }
        )
    }
}
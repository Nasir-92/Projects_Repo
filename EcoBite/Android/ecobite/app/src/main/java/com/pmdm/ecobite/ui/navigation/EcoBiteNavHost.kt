package com.pmdm.ecobite.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pmdm.ecobite.ui.features.creacuenta.CrearCuentaScreen
import com.pmdm.ecobite.ui.features.creacuenta.CrearCuentaViewModel
import com.pmdm.ecobite.ui.features.inicio.InicioScreen
import com.pmdm.ecobite.ui.features.inicio.InicioViewModel
import com.pmdm.ecobite.ui.features.login.LoginScreen
import com.pmdm.ecobite.ui.features.login.LoginViewModel
import com.pmdm.ecobite.ui.features.perfil.PerfilScreen
import com.pmdm.ecobite.ui.features.perfil.PerfilViewModel
import com.pmdm.ecobite.ui.features.receta.RecetaScreen
import com.pmdm.ecobite.ui.features.receta.RecetaViewModel
import com.pmdm.ecobite.ui.features.recuperacontrasenia.RecuperarContraseñaViewModel
import com.pmdm.ecobite.ui.features.restaurante.RestauranteScreen
import com.pmdm.ecobite.ui.features.restaurante.RestauranteViewModel

@Composable
fun EcoBiteNavHost() {

    val navController = rememberNavController()

    val loginViewModel: LoginViewModel = hiltViewModel()
    val inicioViewModel: InicioViewModel = hiltViewModel()
    val crearCuentaViewModel: CrearCuentaViewModel = hiltViewModel()
    val perfilViewModel: PerfilViewModel = hiltViewModel()
    val recuperarViewModel: RecuperarContraseñaViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {

            LoginScreen(
                loginUiState = loginViewModel.uiState.value,
                onLoginEvent = { event ->

                    loginViewModel.onEvent(event)

                    if (loginViewModel.uiState.value.loginCorrecto) {

                        navController.navigate("inicio")
                    }
                }
            )
        }

        composable("inicio") {

            InicioScreen(
                uiState = inicioViewModel.uiState.value,

                onEvent = { event ->
                    inicioViewModel.onEvent(event)
                },

                onClickRestaurante = { idRestaurante ->
                    navController.navigate("restaurante/$idRestaurante")
                },

                onClickReceta = { idReceta ->
                    navController.navigate("receta/$idReceta")
                },

                onClickPerfil = {
                    perfilViewModel.cargarUsuario(1)
                    navController.navigate("perfil")
                }
            )
        }

        composable("perfil") {

            PerfilScreen(
                uiState = perfilViewModel.uiState.value,
                onEvent = { event ->
                    perfilViewModel.onEvent(event)
                }
            )
        }

        composable(
            route = "restaurante/{idRestaurante}",
            arguments = listOf(
                navArgument("idRestaurante") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val restauranteViewModel: RestauranteViewModel = hiltViewModel()

            val idRestaurante =
                backStackEntry.arguments?.getInt("idRestaurante")

            restauranteViewModel.setRestaurante(idRestaurante)

            RestauranteScreen(
                uiState = restauranteViewModel.uiState.value,

                onEvent = { event ->
                    restauranteViewModel.onEvent(event)
                },

                onClickReceta = { idReceta ->
                    navController.navigate("receta/$idReceta")
                },

                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "receta/{idReceta}",
            arguments = listOf(
                navArgument("idReceta") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val recetaViewModel: RecetaViewModel = hiltViewModel()

            val idReceta =
                backStackEntry.arguments?.getInt("idReceta")

            recetaViewModel.setReceta(idReceta)

            RecetaScreen(
                uiState = recetaViewModel.uiState.value,

                onEvent = { event ->
                    recetaViewModel.onEvent(event)
                },

                onBack = {
                    navController.popBackStack()
                },

                onClickRestaurante = { idRestaurante ->
                    navController.navigate("restaurante/$idRestaurante")
                }
            )
        }

        composable("crear_cuenta") {

            CrearCuentaScreen(
                viewModel = crearCuentaViewModel,

                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

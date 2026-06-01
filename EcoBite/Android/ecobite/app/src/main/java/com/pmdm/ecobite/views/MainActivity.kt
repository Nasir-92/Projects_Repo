package com.pmdm.ecobite.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

import com.pmdm.ecobite.theme.EcobiteTheme

import com.pmdm.ecobite.ui.features.receta.RecetaViewModel
import com.pmdm.ecobite.ui.features.restaurante.RestauranteViewModel
import com.pmdm.ecobite.ui.features.perfil.PerfilViewModel

import com.pmdm.ecobite.ui.features.creacuenta.CrearCuentaViewModel
import com.pmdm.ecobite.ui.features.inicio.InicioViewModel
import com.pmdm.ecobite.ui.features.login.LoginViewModel
import com.pmdm.ecobite.ui.features.recuperacontrasenia.RecuperarContraseñaViewModel

import com.pmdm.ecobite.ui.navigation.EcoBiteNavHost

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //////////////////////////////////////////////////////
    // VIEWMODELS
    //////////////////////////////////////////////////////

    private val vmLogin by viewModels<LoginViewModel>()

    private val vmInicio by viewModels<InicioViewModel>()

    private val vmRestaurante by
    viewModels<RestauranteViewModel>()

    private val vmReceta by
    viewModels<RecetaViewModel>()

    private val vmCrearCuenta by
    viewModels<CrearCuentaViewModel>()

    private val vmRecuperarContrasenia by
    viewModels<RecuperarContraseñaViewModel>()

    private val vmPerfil by
    viewModels<PerfilViewModel>()

    //////////////////////////////////////////////////////
    // ON CREATE
    //////////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            EcobiteTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme
                        .colorScheme
                        .background
                ) {

                    EcoBiteNavHost(


                    )
                }
            }
        }
    }
}
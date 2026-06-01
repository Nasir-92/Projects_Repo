package com.pmdm.ecobite.ui.features.perfil

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.pmdm.ecobite.data.mocks.usuario.UsuarioRepository
import com.pmdm.ecobite.ui.features.perfil.PerfilEvent
import com.pmdm.ecobite.ui.features.perfil.PerfilUiState

@HiltViewModel
class PerfilViewModel @Inject constructor() : ViewModel() {

    private val usuarioRepository = UsuarioRepository()

    private val _uiState = mutableStateOf(PerfilUiState())
    val uiState: State<PerfilUiState> = _uiState

    fun cargarUsuario(idUsuario: Int) {

        val usuario = usuarioRepository.getById(idUsuario)

        _uiState.value = _uiState.value.copy(
            nombre = usuario?.nombre ?: "",
            email = usuario?.email ?: "",
            ubicacion = usuario?.ubicacion ?: ""
        )
    }

    fun onEvent(event: PerfilEvent) {

        when (event) {

            is PerfilEvent.OnCambiarNombre -> {

                _uiState.value = _uiState.value.copy(
                    nombre = event.texto
                )
            }

            is PerfilEvent.OnCambiarEmail -> {

                _uiState.value = _uiState.value.copy(
                    email = event.texto
                )
            }

            is PerfilEvent.OnCambiarUbicacion -> {

                _uiState.value = _uiState.value.copy(
                    ubicacion = event.texto
                )
            }

            is PerfilEvent.OnClickGuardarPerfil -> {
                // guardar perfil
            }

            is PerfilEvent.OnClickCambiarContrasena -> {
                // navegación
            }

            is PerfilEvent.OnClickSoporte -> {
                // navegación
            }

            is PerfilEvent.OnClickVolver -> {
                // navegación
            }
        }
    }
}
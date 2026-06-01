
package com.pmdm.ecobite.ui.features.recuperacontrasenia

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.ecobite.data.remote.dto.UsuarioCreateDto
import com.pmdm.ecobite.network.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecuperarContraseñaViewModel @Inject constructor() : ViewModel() {

    private val _uiState =
        mutableStateOf(
            RecuperarContraseniaUiState()
        )

    val uiState:
            State<RecuperarContraseniaUiState> =
        _uiState

    fun onEvent(
        event: RecuperarContraseniaEvent
    ) {

        when (event) {

            is RecuperarContraseniaEvent.OnEmailChanged -> {

                _uiState.value =
                    _uiState.value.copy(
                        email = event.email
                    )
            }

            is RecuperarContraseniaEvent
            .OnNuevaContraseñaChanged -> {

                _uiState.value =
                    _uiState.value.copy(
                        nuevaPassword =
                            event.contrasenia
                    )
            }

            is RecuperarContraseniaEvent
            .OnConfirmarContraseñaChanged -> {

                _uiState.value =
                    _uiState.value.copy(
                        confirmarPassword =
                            event.contrasenia
                    )
            }

            is RecuperarContraseniaEvent
            .OnCambiarContraseñaClick -> {

                viewModelScope.launch {

                    try {

                        val usuarios =
                            RetrofitInstance
                                .api
                                .getUsuarios()

                        if (
                            usuarios.isSuccessful
                        ) {

                            val usuario =
                                usuarios.body()
                                    ?.find {
                                        it.email ==
                                                _uiState.value.email
                                    }

                            if (usuario != null) {

                                val body =
                                    UsuarioCreateDto(
                                        nombre =
                                            usuario.nombre,

                                        apellidos =
                                            usuario.apellidos,

                                        telefono =
                                            usuario.telefono,

                                        email =
                                            usuario.email,

                                        nuevaPassword =
                                            _uiState
                                                .value
                                                .nuevaPassword,

                                        ubicacion =
                                            usuario.ubicacion
                                    )

                                RetrofitInstance.api
                                    .cambiarPasswordUsuario(
                                        usuario.idUsuario,
                                        body
                                    )

                                _uiState.value =
                                    _uiState.value.copy(
                                        mensajeExito =
                                            "Contraseña actualizada",
                                        errorMessage =
                                            null
                                    )

                            } else {

                                _uiState.value =
                                    _uiState.value.copy(
                                        errorMessage =
                                            "Usuario no encontrado"
                                    )
                            }
                        }

                    } catch (e: Exception) {

                        _uiState.value =
                            _uiState.value.copy(
                                errorMessage =
                                    e.message
                            )
                    }
                }
            }

            else -> {}
        }
    }
}
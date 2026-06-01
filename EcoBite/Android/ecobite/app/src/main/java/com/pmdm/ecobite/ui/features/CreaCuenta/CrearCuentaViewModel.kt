
package com.pmdm.ecobite.ui.features.creacuenta

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.ecobite.data.remote.dto.UsuarioCreateDto
import com.pmdm.ecobite.network.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CrearCuentaViewModel @Inject constructor() : ViewModel() {

    private val repository = RemoteRepository()

    private val _uiState =
        mutableStateOf(CrearCuentaUiState())

    val uiState: State<CrearCuentaUiState> =
        _uiState

    fun onEvent(event: CrearCuentaEvent) {

        when (event) {

            is CrearCuentaEvent.OnNombreChanged -> {
                _uiState.value =
                    _uiState.value.copy(
                        nombre = event.nombre
                    )
            }

            is CrearCuentaEvent.OnApellidosChanged -> {
                _uiState.value =
                    _uiState.value.copy(
                        apellidos = event.apellidos
                    )
            }

            is CrearCuentaEvent.OnTelefonoChanged -> {
                _uiState.value =
                    _uiState.value.copy(
                        telefono = event.telefono
                    )
            }

            is CrearCuentaEvent.OnEmailChanged -> {
                _uiState.value =
                    _uiState.value.copy(
                        email = event.email
                    )
            }

            is CrearCuentaEvent.OnPasswordChanged -> {
                _uiState.value =
                    _uiState.value.copy(
                        password = event.password
                    )
            }

            is CrearCuentaEvent.OnRepetirPasswordChanged -> {
                _uiState.value =
                    _uiState.value.copy(
                        repetirPassword =
                            event.repetirPassword
                    )
            }

            is CrearCuentaEvent.OnConfirmarClick -> {

                val state = _uiState.value

                if (
                    state.password !=
                    state.repetirPassword
                ) {

                    _uiState.value =
                        state.copy(
                            errorMessage =
                                "Las contraseñas no coinciden"
                        )

                    return
                }

                viewModelScope.launch {

                    try {

                        val usuario =
                            UsuarioCreateDto(
                                nombre = state.nombre,
                                apellidos = state.apellidos,
                                telefono = state.telefono,
                                email = state.email,
                                nuevaPassword = state.password,
                                ubicacion = "España"
                            )

                        val response =
                            repository.crearUsuario(usuario)

                        if (response.isSuccessful) {

                            _uiState.value =
                                state.copy(
                                    errorMessage = null
                                )

                        } else {

                            _uiState.value =
                                state.copy(
                                    errorMessage =
                                        "No se pudo crear la cuenta"
                                )
                        }

                    } catch (e: Exception) {

                        _uiState.value =
                            state.copy(
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
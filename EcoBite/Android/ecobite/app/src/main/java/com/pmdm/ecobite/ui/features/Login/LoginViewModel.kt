package com.pmdm.ecobite.ui.features.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.ecobite.data.remote.dto.LoginDto
import com.pmdm.ecobite.data.remote.dto.UsuarioCreateDto
import com.pmdm.ecobite.network.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    //////////////////////////////////////////////////////
    // REPOSITORY
    //////////////////////////////////////////////////////

    private val repository =
        RemoteRepository()

    //////////////////////////////////////////////////////
    // UI STATE
    //////////////////////////////////////////////////////

    private val _uiState =
        mutableStateOf(
            LoginUiState()
        )

    val uiState: State<LoginUiState> =
        _uiState

    //////////////////////////////////////////////////////
    // EVENTS
    //////////////////////////////////////////////////////

    fun onEvent(event: LoginEvent) {

        when (event) {

            //////////////////////////////////////////////////////
            // EMAIL
            //////////////////////////////////////////////////////

            is LoginEvent.OnEmailChanged -> {

                _uiState.value =
                    _uiState.value.copy(
                        email = event.email
                    )
            }

            //////////////////////////////////////////////////////
            // PASSWORD
            //////////////////////////////////////////////////////

            is LoginEvent.OnPasswordChanged -> {

                _uiState.value =
                    _uiState.value.copy(
                        password = event.password
                    )
            }

            //////////////////////////////////////////////////////
            // LOGIN
            //////////////////////////////////////////////////////

            is LoginEvent.OnLoginClick -> {

                viewModelScope.launch {

                    try {

                        val response =
                            repository
                                .login(

                                    LoginDto(

                                        email =_uiState.value.email,

                                        nuevaPassword =_uiState.value.password
                                    )
                                )
                        println("EMAIL: ${_uiState.value.email}")
                        println("PASSWORD: ${_uiState.value.password}")

                        println("CODE: ${response.code()}")
                        println("BODY: ${response.body()}")
                        println("ERROR: ${response.errorBody()?.string()}")
                        //////////////////////////////////////////////////////
                        // LOGIN OK
                        //////////////////////////////////////////////////////

                        if (response.isSuccessful) {

                            _uiState.value =
                                _uiState.value.copy(
                                    loginCorrecto = true,
                                    errorMessage = null
                                )

                            //////////////////////////////////////////////////////
                            // LOGIN ERROR
                            //////////////////////////////////////////////////////

                        } else {

                            _uiState.value =
                                _uiState.value.copy(
                                    loginCorrecto = false,
                                    errorMessage =
                                        "Usuario o contraseña incorrectos"
                                )
                        }

                        //////////////////////////////////////////////////////
                        // EXCEPTION
                        //////////////////////////////////////////////////////

                    } catch (e: Exception) {

                        e.printStackTrace()

                        _uiState.value =
                            _uiState.value.copy(
                                loginCorrecto = false,
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
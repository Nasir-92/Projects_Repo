
package com.pmdm.ecobite.ui.features.inicio

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.ecobite.network.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InicioViewModel @Inject constructor() : ViewModel() {

    private val repository =
        RemoteRepository()

    private val _uiState =
        mutableStateOf(
            InicioUiState()
        )

    val uiState: State<InicioUiState> =
        _uiState

    init {

        cargarDatos()
    }

    private fun cargarDatos() {

        viewModelScope.launch {

            try {

                val restaurantesResponse =
                    repository.getRestaurantes()

                val recetasResponse =
                    repository.getRecetas()

                if (
                    restaurantesResponse.isSuccessful &&
                    recetasResponse.isSuccessful
                ) {

                    _uiState.value =
                        _uiState.value.copy(
                            restaurantes =
                                restaurantesResponse.body()
                                    ?: emptyList(),
                            recetasRestaurante =
                                recetasResponse.body()
                                    ?: emptyList()
                        )
                }

            } catch (_: Exception) {

            }
        }
    }

    fun onEvent(
        event: InicioEvent
    ) {
    }
}
package com.pmdm.ecobite.ui.features.restaurante

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.pmdm.ecobite.data.mocks.receta.RecetaRepository
import com.pmdm.ecobite.data.mocks.restaurante.RestauranteRepository
import com.pmdm.ecobite.ui.features.restaurante.RestauranteEvent
import com.pmdm.ecobite.ui.features.restaurante.RestauranteUiState

@HiltViewModel
class RestauranteViewModel @Inject constructor() : ViewModel() {

    private val restauranteRepository = RestauranteRepository()
    private val recetaRepository = RecetaRepository()

    private val _uiState = mutableStateOf(RestauranteUiState())
    val uiState: State<RestauranteUiState> = _uiState


    fun setRestaurante(idRestaurante: Int?) {

        if (idRestaurante == null) return

        if (_uiState.value.restaurante?.idRestaurante == idRestaurante) return

        cargarRestaurante(idRestaurante)
    }

    private fun cargarRestaurante(idRestaurante: Int) {

        val restaurante =
            restauranteRepository.getById(idRestaurante)

        val recetas =
            recetaRepository.getAll()
                .filter {
                    it.idRestaurante == idRestaurante
                }

        _uiState.value = _uiState.value.copy(
            restaurante = restaurante,
            recetas = recetas,
            recetasFiltradas = recetas,
            indiceRecetaSeleccionada = 0
        )
    }

    fun onEvent(event: RestauranteEvent) {

        when (event) {

            RestauranteEvent.OnBackClick -> {}

            RestauranteEvent.OnSettingsClick -> {}

            is RestauranteEvent.OnSearchChanged -> {

                val texto = event.texto

                val recetasFiltradas =
                    _uiState.value.recetas.filter {

                        it.nombre.contains(
                            texto,
                            ignoreCase = true
                        )
                    }

                _uiState.value = _uiState.value.copy(
                    searchText = texto,
                    recetasFiltradas = recetasFiltradas,
                    indiceRecetaSeleccionada = 0
                )
            }

            RestauranteEvent.OnPlatoAnteriorClick -> {

                val index =
                    _uiState.value.indiceRecetaSeleccionada

                if (index > 0) {

                    _uiState.value = _uiState.value.copy(
                        indiceRecetaSeleccionada = index - 1
                    )
                }
            }

            RestauranteEvent.OnPlatoSiguienteClick -> {

                val index =
                    _uiState.value.indiceRecetaSeleccionada

                val max =
                    _uiState.value.recetasFiltradas.size - 1

                if (index < max) {

                    _uiState.value = _uiState.value.copy(
                        indiceRecetaSeleccionada = index + 1
                    )
                }
            }

            RestauranteEvent.OnClickReceta -> {}
        }
    }
}
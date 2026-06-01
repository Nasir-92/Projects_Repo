package com.pmdm.ecobite.ui.features.receta

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.pmdm.ecobite.data.mocks.receta.RecetaRepository
import com.pmdm.ecobite.data.mocks.restaurante.RestauranteRepository
import com.pmdm.ecobite.ui.features.receta.RecetaEvent
import com.pmdm.ecobite.ui.features.receta.RecetaUiState

@HiltViewModel
class RecetaViewModel @Inject constructor() : ViewModel() {

    private val recetaRepository = RecetaRepository()
    private val restauranteRepository = RestauranteRepository()

    private val _uiState = mutableStateOf(RecetaUiState())
    val uiState: State<RecetaUiState> = _uiState


    // 👇 MÉTODO QUE USA LA NAVIGATION
    fun setReceta(idReceta: Int?) {

        if (idReceta == null) return

        if (_uiState.value.receta?.idReceta == idReceta) return

        cargarReceta(idReceta)
    }


    private fun cargarReceta(idReceta: Int) {

        val receta = recetaRepository.getById(idReceta)

        val restaurante = receta?.let {
            restauranteRepository.getById(it.idRestaurante)
        }

        _uiState.value = _uiState.value.copy(
            receta = receta,
            restaurante = restaurante
        )
    }


    fun onEvent(event: RecetaEvent) {

        when (event) {

            is RecetaEvent.OnSearchChanged -> {

                _uiState.value = _uiState.value.copy(
                    searchText = event.text
                )
            }

            is RecetaEvent.OnBackClicked -> {
                // navegación desde NavHost
            }

            is RecetaEvent.OnSettingsClicked -> {
                // navegación después
            }

            is RecetaEvent.OnClickRestaurante -> {
                // navegación después
            }
        }
    }
}
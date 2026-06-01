package com.pmdm.ecobite.ui.features.inicio

import com.pmdm.ecobite.models.Restaurante
import com.pmdm.ecobite.models.Receta

data class InicioUiState(

    val textoBusqueda: String = "",

    val restaurantes: List<Restaurante> = emptyList(),

    val recetasRestaurante: List<Receta> = emptyList(),

    val indiceRestauranteSeleccionado: Int = 0,

    val indiceRecetaSeleccionada: Int = 0
)
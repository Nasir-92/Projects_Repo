package com.pmdm.ecobite.ui.features.receta

import com.pmdm.ecobite.models.Receta
import com.pmdm.ecobite.models.Restaurante

data class RecetaUiState(

    val searchText: String = "",

    val receta: Receta? = null,

    val restaurante: Restaurante? = null
)
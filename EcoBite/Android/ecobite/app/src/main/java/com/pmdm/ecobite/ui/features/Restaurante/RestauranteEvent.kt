package com.pmdm.ecobite.ui.features.restaurante

sealed interface RestauranteEvent {

    data class OnSearchChanged(
        val texto: String
    ) : RestauranteEvent

    object OnBackClick : RestauranteEvent

    object OnSettingsClick : RestauranteEvent

    object OnPlatoAnteriorClick : RestauranteEvent

    object OnPlatoSiguienteClick : RestauranteEvent

    object OnClickReceta : RestauranteEvent
}
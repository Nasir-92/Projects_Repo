package com.pmdm.ecobite.ui.features.receta

sealed interface RecetaEvent {

    object OnBackClicked : RecetaEvent

    object OnSettingsClicked : RecetaEvent

    data class OnSearchChanged(val text: String) : RecetaEvent

    object OnClickRestaurante : RecetaEvent
}
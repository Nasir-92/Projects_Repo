package com.pmdm.ecobite.ui.features.inicio

sealed interface InicioEvent {

    data class OnBusquedaChanged(val texto: String) : InicioEvent

    object OnClickPerfil : InicioEvent

    object OnClickLogo : InicioEvent

    object OnRestauranteAnterior : InicioEvent

    object OnRestauranteSiguiente : InicioEvent

    object OnClickRestaurante : InicioEvent

    object OnRecetaAnterior : InicioEvent

    object OnRecetaSiguiente : InicioEvent

    object OnClickReceta : InicioEvent
}
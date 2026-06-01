package com.pmdm.ecobite.ui.utils

import com.pmdm.ecobite.R

fun obtenerDrawable(nombre: String): Int {

    return when (nombre.lowercase()) {

        "ecofood.jpg" -> R.drawable.ecofood
        "greengarden.jpg" -> R.drawable.greengarden
        "kebabbueno.jpg" -> R.drawable.kebabbueno

        "ecoburger.jpg" -> R.drawable.ecoburger
        "ecowrap.jpg" -> R.drawable.ecowrap
        "greenpasta.jpg" -> R.drawable.greenpasta
        "greenbowl.jpg" -> R.drawable.greenbowl
        "kebabplato.jpg" -> R.drawable.kebabplato

        else -> R.drawable.logo
    }
}
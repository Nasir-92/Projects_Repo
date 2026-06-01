package com.pmdm.ecobite.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RecipeCard(
    image: Int,
    onClick: () -> Unit
) {

    Image(
        painter = painterResource(id = image),
        contentDescription = "Receta",
        modifier = Modifier
            .size(220.dp, 130.dp)
            .clickable { onClick() },
        contentScale = ContentScale.Crop
    )
}


package com.pmdm.ecobite.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pmdm.ecobite.R

@Composable
fun RestaurantCard(
    image: Int,
    onClick: () -> Unit
) {

    Image(
        painter = painterResource(id = image),
        contentDescription = "Restaurante",
        modifier = Modifier
            .size(220.dp, 130.dp)
            .clickable { onClick() },
        contentScale = ContentScale.Crop
    )
}


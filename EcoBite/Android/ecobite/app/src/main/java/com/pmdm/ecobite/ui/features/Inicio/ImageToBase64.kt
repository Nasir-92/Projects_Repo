package com.pmdm.ecobite.ui.utils

import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap

fun base64ToImageBitmap(
    base64String: String
): ImageBitmap {

    val imageBytes =
        Base64.decode(
            base64String,
            Base64.DEFAULT
        )

    val bitmap =
        BitmapFactory.decodeByteArray(
            imageBytes,
            0,
            imageBytes.size
        )

    return bitmap.asImageBitmap()
}
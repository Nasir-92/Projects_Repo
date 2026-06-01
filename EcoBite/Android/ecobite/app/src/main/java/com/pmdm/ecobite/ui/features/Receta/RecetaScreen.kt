package com.pmdm.ecobite.ui.features.receta

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.ecobite.models.Receta
import com.pmdm.ecobite.models.Restaurante
import com.pmdm.ecobite.ui.utils.obtenerDrawable
import java.time.LocalDateTime

@Composable
fun RecetaScreen(
    uiState: RecetaUiState,
    onEvent: (RecetaEvent) -> Unit,
    onBack: () -> Unit,
    onClickRestaurante: (Int) -> Unit
) {

    val receta = uiState.receta
    val restaurante = uiState.restaurante

    Scaffold(
        containerColor = Color(0xFF101010)
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {

            //////////////////////////////////////////////////////
            // HEADER
            //////////////////////////////////////////////////////

            receta?.let {

                Box {

                    //////////////////////////////////////////////////////
                    // IMAGEN RECETA
                    //////////////////////////////////////////////////////

                    Image(
                        painter = painterResource(
                            obtenerDrawable(it.imagen)
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(320.dp),
                        contentScale = ContentScale.Crop
                    )

                    //////////////////////////////////////////////////////
                    // DEGRADADO
                    //////////////////////////////////////////////////////

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(320.dp)
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color.Transparent,
                                        Color.Black.copy(alpha = 0.85f)
                                    )
                                )
                            )
                    )

                    //////////////////////////////////////////////////////
                    // BOTON BACK
                    //////////////////////////////////////////////////////

                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(48.dp)
                            .background(
                                Color.Black.copy(alpha = 0.4f),
                                CircleShape
                            )
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    //////////////////////////////////////////////////////
                    // INFO RECETA + RESTAURANTE
                    //////////////////////////////////////////////////////

                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(20.dp)
                    ) {

                        //////////////////////////////////////////////////////
                        // RESTAURANTE MINI CARD
                        //////////////////////////////////////////////////////

                        restaurante?.let { rest ->

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .background(
                                        Color.Black.copy(alpha = 0.45f),
                                        RoundedCornerShape(50.dp)
                                    )
                                    .padding(
                                        horizontal = 12.dp,
                                        vertical = 8.dp
                                    )
                                    .clickable {

                                        onClickRestaurante(
                                            rest.idRestaurante
                                        )
                                    }
                            ) {

                                Image(
                                    painter = painterResource(
                                        obtenerDrawable(rest.imagen)
                                    ),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(42.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(Modifier.width(10.dp))

                                Column {

                                    Text(
                                        text = rest.nombre,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Text(
                                        text = "Ver restaurante",
                                        color = Color.LightGray,
                                        fontSize = 12.sp
                                    )
                                }
                            }

                            Spacer(Modifier.height(18.dp))
                        }

                        //////////////////////////////////////////////////////
                        // TITULO RECETA
                        //////////////////////////////////////////////////////

                        Text(
                            text = it.nombre,
                            color = Color.White,
                            fontSize = 34.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(10.dp))

                        Text(
                            text = it.descripcion,
                            color = Color.LightGray,
                            fontSize = 16.sp
                        )
                    }
                }
            }

            //////////////////////////////////////////////////////
            // CONTENIDO
            //////////////////////////////////////////////////////

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                //////////////////////////////////////////////////////
                // SEARCH BAR
                //////////////////////////////////////////////////////

                OutlinedTextField(
                    value = uiState.searchText,
                    onValueChange = {
                        onEvent(
                            RecetaEvent.OnSearchChanged(it)
                        )
                    },
                    placeholder = {
                        Text("Buscar en la receta...")
                    },
                    leadingIcon = {

                        Icon(
                            Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                Spacer(Modifier.height(30.dp))

                //////////////////////////////////////////////////////
                // PREPARACION
                //////////////////////////////////////////////////////

                Text(
                    text = "👨‍🍳 Preparación",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(16.dp))

                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1E1E1E)
                    )
                ) {

                    Text(
                        text = receta?.pasos ?: "",
                        color = Color.LightGray,
                        fontSize = 16.sp,
                        lineHeight = 28.sp,
                        modifier = Modifier.padding(20.dp)
                    )
                }

                Spacer(Modifier.height(32.dp))

                //////////////////////////////////////////////////////
                // RESTAURANTE
                //////////////////////////////////////////////////////

                Text(
                    text = "🏪 Restaurante",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(16.dp))

                restaurante?.let {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                                onClickRestaurante(
                                    it.idRestaurante
                                )
                            },
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF1E1E1E)
                        ),
                        elevation = CardDefaults.cardElevation(10.dp)
                    ) {

                        Column {

                            Image(
                                painter = painterResource(
                                    obtenerDrawable(it.imagen)
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp),
                                contentScale = ContentScale.Crop
                            )

                            Column(
                                modifier = Modifier.padding(20.dp)
                            ) {

                                Text(
                                    text = it.nombre,
                                    color = Color.White,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(Modifier.height(8.dp))

                                Text(
                                    text = "📍 ${it.ubicacion}",
                                    color = Color.LightGray
                                )

                                Spacer(Modifier.height(6.dp))

                                Text(
                                    text = "🕒 ${it.horario}",
                                    color = Color.LightGray
                                )

                                Spacer(Modifier.height(14.dp))

                                Text(
                                    text = "Ver restaurante →",
                                    color = Color(0xFF4CAF50),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

                //////////////////////////////////////////////////////
                // EMPTY SEARCH
                //////////////////////////////////////////////////////

                if (
                    uiState.searchText.isNotBlank()
                    &&
                    receta?.pasos?.contains(
                        uiState.searchText,
                        ignoreCase = true
                    ) == false
                ) {

                    Spacer(Modifier.height(40.dp))

                    Text(
                        text = "No se encontró texto en la receta 😢",
                        color = Color.White,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Spacer(Modifier.height(40.dp))
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewRecetaScreen() {

    val restaurante = Restaurante(
        idRestaurante = 1,
        nombre = "EcoFood",
        email = "",
        password = "",
        telefono = "",
        ubicacion = "Alicante",
        horario = "10:00 - 23:00",
        descripcion = "Restaurante ecológico",
        imagen = "ecofood.jpg",
        createdAt = LocalDateTime.now()
    )

    val receta = Receta(
        idReceta = 1,
        idRestaurante = 1,
        nombre = "EcoBurger",
        descripcion =
            "Hamburguesa vegana con ingredientes ecológicos",
        pasos =
            "1. Preparar ingredientes\n\n" +
                    "2. Cocinar hamburguesa\n\n" +
                    "3. Montar el pan\n\n" +
                    "4. Añadir vegetales\n\n" +
                    "5. Servir caliente",
        imagen = "ecoburger.jpg",
        createdAt = LocalDateTime.now()
    )

    RecetaScreen(
        uiState = RecetaUiState(
            receta = receta,
            restaurante = restaurante,
            searchText = ""
        ),
        onEvent = {},
        onBack = {},
        onClickRestaurante = {}
    )
}
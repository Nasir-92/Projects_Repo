package com.pmdm.ecobite.ui.features.restaurante

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.ecobite.models.Receta
import com.pmdm.ecobite.models.Restaurante
import com.pmdm.ecobite.ui.utils.obtenerDrawable
import java.time.LocalDateTime

@Composable
fun RestauranteScreen(
    uiState: RestauranteUiState,
    onEvent: (RestauranteEvent) -> Unit,
    onClickReceta: (Int) -> Unit,
    onBack: () -> Unit
) {

    val restaurante = uiState.restaurante

    Scaffold(
        containerColor = Color(0xFF101010)
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            //////////////////////////////////////////////////////
            // HEADER RESTAURANTE
            //////////////////////////////////////////////////////

            restaurante?.let {

                Box {

                    //////////////////////////////////////////////////////
                    // IMAGEN HEADER
                    //////////////////////////////////////////////////////

                    Image(
                        painter = painterResource(
                            obtenerDrawable(it.imagen)
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(260.dp)
                            .clip(RoundedCornerShape(28.dp)),
                        contentScale = ContentScale.Crop
                    )

                    //////////////////////////////////////////////////////
                    // DEGRADADO
                    //////////////////////////////////////////////////////

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(260.dp)
                            .clip(RoundedCornerShape(28.dp))
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color.Transparent,
                                        Color.Black.copy(alpha = 0.8f)
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
                    // INFO RESTAURANTE
                    //////////////////////////////////////////////////////

                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(20.dp)
                    ) {

                        Text(
                            text = it.nombre,
                            color = Color.White,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "📍 ${it.ubicacion}",
                            color = Color.White
                        )

                        Spacer(Modifier.height(4.dp))

                        Text(
                            text = "🕒 ${it.horario}",
                            color = Color.White
                        )
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            //////////////////////////////////////////////////////
            // SEARCH BAR
            //////////////////////////////////////////////////////

            OutlinedTextField(
                value = uiState.searchText,
                onValueChange = {
                    onEvent(
                        RestauranteEvent.OnSearchChanged(it)
                    )
                },
                placeholder = {
                    Text("Buscar recetas...")
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

            Spacer(Modifier.height(28.dp))

            //////////////////////////////////////////////////////
            // TITULO
            //////////////////////////////////////////////////////

            Text(
                text = "🔥 Recetas populares",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(20.dp))

            //////////////////////////////////////////////////////
            // RECETAS
            //////////////////////////////////////////////////////

            Row(
                modifier = Modifier.horizontalScroll(
                    rememberScrollState()
                )
            ) {

                uiState.recetasFiltradas.forEach { receta ->

                    Card(
                        modifier = Modifier
                            .width(260.dp)
                            .padding(end = 16.dp)
                            .clickable {

                                onClickReceta(receta.idReceta)
                            },
                        shape = RoundedCornerShape(24.dp),
                        elevation = CardDefaults.cardElevation(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF1E1E1E)
                        )
                    ) {

                        Column {

                            Image(
                                painter = painterResource(
                                    obtenerDrawable(receta.imagen)
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp),
                                contentScale = ContentScale.Crop
                            )

                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {

                                Text(
                                    text = receta.nombre,
                                    color = Color.White,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(Modifier.height(8.dp))

                                Text(
                                    text = receta.descripcion,
                                    color = Color.LightGray,
                                    fontSize = 14.sp,
                                    maxLines = 3
                                )

                                Spacer(Modifier.height(16.dp))

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Box(
                                        modifier = Modifier
                                            .size(12.dp)
                                            .clip(CircleShape)
                                            .background(Color.Green)
                                    )

                                    Spacer(Modifier.width(8.dp))

                                    Text(
                                        text = "Eco Friendly",
                                        color = Color.Green
                                    )
                                }
                            }
                        }
                    }
                }
            }

            //////////////////////////////////////////////////////
            // EMPTY STATE
            //////////////////////////////////////////////////////

            if (
                uiState.recetasFiltradas.isEmpty()
                && uiState.searchText.isNotBlank()
            ) {

                Spacer(Modifier.height(40.dp))

                Text(
                    text = "No se encontraron recetas 😢",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewRestauranteScreen() {

    val restaurante = Restaurante(
        idRestaurante = 1,
        nombre = "EcoBite Alicante",
        email = "",
        password = "",
        telefono = "965123456",
        ubicacion = "Alicante",
        horario = "10:00 - 23:00",
        descripcion = "Restaurante ecológico premium",
        imagen = "ecofood.jpg",
        createdAt = LocalDateTime.now()
    )

    val recetas = listOf(

        Receta(
            idReceta = 1,
            idRestaurante = 1,
            nombre = "Eco Burger",
            descripcion =
                "Hamburguesa ecológica con ingredientes 100% naturales y pan artesanal.",
            pasos = "",
            imagen = "ecoburger.jpg",
            createdAt = LocalDateTime.now()
        ),

        Receta(
            idReceta = 2,
            idRestaurante = 1,
            nombre = "Green Wrap",
            descripcion =
                "Wrap saludable con verduras frescas y salsa eco especial.",
            pasos = "",
            imagen = "ecowrap.jpg",
            createdAt = LocalDateTime.now()
        ),

        Receta(
            idReceta = 3,
            idRestaurante = 1,
            nombre = "Vegan Bowl",
            descripcion =
                "Bowl vegano con quinoa, aguacate y proteína vegetal.",
            pasos = "",
            imagen = "veganbowl.jpg",
            createdAt = LocalDateTime.now()
        )
    )

    RestauranteScreen(

        uiState = RestauranteUiState(

            restaurante = restaurante,

            recetas = recetas,

            recetasFiltradas = recetas,

            searchText = "",

            indiceRecetaSeleccionada = 0
        ),

        onEvent = {},

        onClickReceta = {},

        onBack = {}
    )
}
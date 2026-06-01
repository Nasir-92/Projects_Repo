package com.pmdm.ecobite.ui.features.inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
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
import com.pmdm.ecobite.R
import com.pmdm.ecobite.models.Receta
import com.pmdm.ecobite.models.Restaurante
import com.pmdm.ecobite.ui.utils.base64ToImageBitmap
import java.time.LocalDateTime

@Composable
fun InicioScreen(
    uiState: InicioUiState,
    onEvent: (InicioEvent) -> Unit,
    onClickRestaurante: (Int) -> Unit,
    onClickReceta: (Int) -> Unit,
    onClickPerfil: () -> Unit
) {

    //////////////////////////////////////////////////////
    // BUSCADOR
    //////////////////////////////////////////////////////

    val restaurantesFiltrados =

        if (uiState.textoBusqueda.isBlank()) {

            uiState.restaurantes

        } else {

            uiState.restaurantes.filter {

                it.nombre.contains(
                    uiState.textoBusqueda,
                    ignoreCase = true
                )
            }
        }

    val recetasFiltradas =

        if (uiState.textoBusqueda.isBlank()) {

            uiState.recetasRestaurante

        } else {

            uiState.recetasRestaurante.filter {

                it.nombre.contains(
                    uiState.textoBusqueda,
                    ignoreCase = true
                )
            }
        }

    Scaffold(
        containerColor = Color(0xFF101010)
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {

            //////////////////////////////////////////////////////
            // HEADER
            //////////////////////////////////////////////////////

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0xFF1B5E20),
                                Color.Black
                            )
                        )
                    )
            ) {

                //////////////////////////////////////////////////////
                // CONTENIDO HEADER
                //////////////////////////////////////////////////////

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(20.dp)
                ) {

                    //////////////////////////////////////////////////////
                    // TOP BAR
                    //////////////////////////////////////////////////////

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                                .clickable {

                                    onEvent(
                                        InicioEvent.OnClickLogo
                                    )
                                },
                            contentAlignment = Alignment.Center
                        ) {

                            Image(
                                painter = painterResource(
                                    R.drawable.logo
                                ),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                            )
                        }

                        Spacer(Modifier.weight(1f))

                        IconButton(
                            onClick = {

                                onClickPerfil()
                            }
                        ) {

                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }

                    Spacer(Modifier.height(28.dp))

                    //////////////////////////////////////////////////////
                    // TITULO
                    //////////////////////////////////////////////////////

                    Text(
                        text = "🌱 EcoBite",
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "Descubre restaurantes y recetas ecológicas",
                        color = Color.LightGray,
                        fontSize = 16.sp
                    )

                    Spacer(Modifier.height(24.dp))

                    //////////////////////////////////////////////////////
                    // SEARCH BAR
                    //////////////////////////////////////////////////////

                    OutlinedTextField(
                        value = uiState.textoBusqueda,
                        onValueChange = {

                            onEvent(
                                InicioEvent.OnBusquedaChanged(it)
                            )
                        },
                        placeholder = {

                            Text(
                                "Buscar restaurantes o recetas..."
                            )
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
                }
            }

            //////////////////////////////////////////////////////
            // CONTENIDO
            //////////////////////////////////////////////////////

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                //////////////////////////////////////////////////////
                // RESTAURANTES
                //////////////////////////////////////////////////////

                Text(
                    text = "🏪 Restaurantes",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(20.dp))

                Row(
                    modifier = Modifier.horizontalScroll(
                        rememberScrollState()
                    )
                ) {

                    restaurantesFiltrados.forEach { restaurante ->

                        Card(
                            modifier = Modifier
                                .width(260.dp)
                                .padding(end = 16.dp)
                                .clickable {

                                    onClickRestaurante(
                                        restaurante.idRestaurante
                                    )
                                },
                            shape = RoundedCornerShape(24.dp),
                            elevation = CardDefaults.cardElevation(10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF1E1E1E)
                            )
                        ) {

                            Column {

                                //////////////////////////////////////////////////////
                                // IMAGEN RESTAURANTE
                                //////////////////////////////////////////////////////

                                Image(
                                    bitmap = base64ToImageBitmap(
                                        restaurante.imagen ?: ""
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
                                        text = restaurante.nombre,
                                        color = Color.White,
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(Modifier.height(8.dp))

                                    Text(
                                        text = restaurante.ubicacion,
                                        color = Color.LightGray
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(Modifier.height(40.dp))

                //////////////////////////////////////////////////////
                // RECETAS
                //////////////////////////////////////////////////////

                Text(
                    text = "🍽 Recetas populares",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(20.dp))

                Row(
                    modifier = Modifier.horizontalScroll(
                        rememberScrollState()
                    )
                ) {

                    recetasFiltradas.forEach { receta ->

                        Card(
                            modifier = Modifier
                                .width(260.dp)
                                .padding(end = 16.dp)
                                .clickable {

                                    onClickReceta(
                                        receta.idReceta
                                    )
                                },
                            shape = RoundedCornerShape(24.dp),
                            elevation = CardDefaults.cardElevation(10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF1E1E1E)
                            )
                        ) {

                            Column {

                                //////////////////////////////////////////////////////
                                // IMAGEN RECETA
                                //////////////////////////////////////////////////////

                                Image(
                                    bitmap = base64ToImageBitmap(
                                        receta.imagen ?: ""
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
                                        maxLines = 3
                                    )
                                }
                            }
                        }
                    }
                }

                //////////////////////////////////////////////////////
                // EMPTY STATE
                //////////////////////////////////////////////////////

                if (
                    restaurantesFiltrados.isEmpty()
                    &&
                    recetasFiltradas.isEmpty()
                    &&
                    uiState.textoBusqueda.isNotBlank()
                ) {

                    Spacer(Modifier.height(40.dp))

                    Text(
                        text = "No se encontraron resultados 😢",
                        color = Color.White,
                        fontSize = 18.sp
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
fun PreviewInicioScreen() {

    val restaurantes = emptyList<Restaurante>()

    val recetas = emptyList<Receta>()

    InicioScreen(
        uiState = InicioUiState(
            restaurantes = restaurantes,
            recetasRestaurante = recetas
        ),
        onEvent = {},
        onClickRestaurante = {},
        onClickReceta = {},
        onClickPerfil = {}
    )
}
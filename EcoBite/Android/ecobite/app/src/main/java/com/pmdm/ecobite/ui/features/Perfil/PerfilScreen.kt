package com.pmdm.ecobite.ui.features.perfil

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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
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

@Composable
fun PerfilScreen(
    uiState: PerfilUiState,
    onEvent: (PerfilEvent) -> Unit
) {

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

            Box {

                //////////////////////////////////////////////////////
                // IMAGEN HEADER
                //////////////////////////////////////////////////////

                Image(
                    painter = painterResource(R.drawable.fondo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )

                //////////////////////////////////////////////////////
                // DEGRADADO
                //////////////////////////////////////////////////////

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    Color.Black.copy(alpha = 0.9f)
                                )
                            )
                        )
                )

                //////////////////////////////////////////////////////
                // BOTON BACK
                //////////////////////////////////////////////////////

                IconButton(
                    onClick = {
                        onEvent(PerfilEvent.OnClickVolver)
                    },
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
                // PERFIL
                //////////////////////////////////////////////////////

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(60.dp),
                            tint = Color.DarkGray
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    Text(
                        text = uiState.nombre,
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(6.dp))

                    Text(
                        text = uiState.email,
                        color = Color.LightGray
                    )
                }
            }

            //////////////////////////////////////////////////////
            // CONTENIDO
            //////////////////////////////////////////////////////

            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {

                //////////////////////////////////////////////////////
                // DATOS PERSONALES
                //////////////////////////////////////////////////////

                Text(
                    text = "👤 Información personal",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(20.dp))

                //////////////////////////////////////////////////////
                // NOMBRE
                //////////////////////////////////////////////////////

                OutlinedTextField(
                    value = uiState.nombre,
                    onValueChange = {
                        onEvent(
                            PerfilEvent.OnCambiarNombre(it)
                        )
                    },
                    label = {
                        Text("Nombre")
                    },
                    leadingIcon = {

                        Icon(
                            Icons.Default.Person,
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

                Spacer(Modifier.height(16.dp))

                //////////////////////////////////////////////////////
                // EMAIL
                //////////////////////////////////////////////////////

                OutlinedTextField(
                    value = uiState.email,
                    onValueChange = {
                        onEvent(
                            PerfilEvent.OnCambiarEmail(it)
                        )
                    },
                    label = {
                        Text("Email")
                    },
                    leadingIcon = {

                        Icon(
                            Icons.Default.Email,
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

                Spacer(Modifier.height(16.dp))

                //////////////////////////////////////////////////////
                // UBICACION
                //////////////////////////////////////////////////////

                OutlinedTextField(
                    value = uiState.ubicacion,
                    onValueChange = {
                        onEvent(
                            PerfilEvent.OnCambiarUbicacion(it)
                        )
                    },
                    label = {
                        Text("Ubicación")
                    },
                    leadingIcon = {

                        Icon(
                            Icons.Default.LocationOn,
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
                // BOTON GUARDAR
                //////////////////////////////////////////////////////

                Button(
                    onClick = {
                        onEvent(
                            PerfilEvent.OnClickGuardarPerfil
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4CAF50)
                    )
                ) {

                    Text(
                        text = "Guardar perfil",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(Modifier.height(32.dp))

                //////////////////////////////////////////////////////
                // OPCIONES
                //////////////////////////////////////////////////////

                Text(
                    text = "⚙️ Opciones",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(20.dp))

                //////////////////////////////////////////////////////
                // CARD OPCIONES
                //////////////////////////////////////////////////////

                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1E1E1E)
                    )
                ) {

                    Column {

                        PerfilItem(
                            texto = "🔒 Cambiar contraseña"
                        ) {

                            onEvent(
                                PerfilEvent.OnClickCambiarContrasena
                            )
                        }

                        Divider(
                            color = Color.DarkGray
                        )

                        PerfilItem(
                            texto = "🎧 Contactar soporte"
                        ) {

                            onEvent(
                                PerfilEvent.OnClickSoporte
                            )
                        }
                    }
                }

                Spacer(Modifier.height(40.dp))
            }
        }
    }
}

@Composable
fun PerfilItem(
    texto: String,
    onClick: () -> Unit
) {

    Text(
        text = texto,
        color = Color.White,
        fontSize = 18.sp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(20.dp)
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewPerfilScreen() {

    PerfilScreen(
        uiState = PerfilUiState(
            nombre = "John Doe",
            email = "john@example.com",
            ubicacion = "Alicante"
        ),
        onEvent = {}
    )
}
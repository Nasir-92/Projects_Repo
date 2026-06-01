package com.pmdm.ecobite.ui.features.creacuenta

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.ecobite.R

@Composable
fun CrearCuentaScreen(

    viewModel: CrearCuentaViewModel,

    onBack: () -> Unit

) {

    val uiState = viewModel.uiState.value

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

            Box {

                Image(
                    painter = painterResource(
                        R.drawable.fondo
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
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

                        onBack()
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
                // LOGO + TITULO
                //////////////////////////////////////////////////////

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(
                                R.drawable.logo
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp)
                        )
                    }

                    Spacer(Modifier.height(20.dp))

                    Text(
                        text = "Crear cuenta",
                        color = Color.White,
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "Únete a la comunidad EcoBite 🌱",
                        color = Color.LightGray,
                        fontSize = 16.sp
                    )
                }
            }

            //////////////////////////////////////////////////////
            // FORMULARIO
            //////////////////////////////////////////////////////

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                //////////////////////////////////////////////////////
                // NOMBRE
                //////////////////////////////////////////////////////

                OutlinedTextField(
                    value = uiState.nombre,
                    onValueChange = {

                        viewModel.onEvent(
                            CrearCuentaEvent.OnNombreChanged(it)
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
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                Spacer(Modifier.height(16.dp))

                //////////////////////////////////////////////////////
                // APELLIDOS
                //////////////////////////////////////////////////////

                OutlinedTextField(
                    value = uiState.apellidos,
                    onValueChange = {

                        viewModel.onEvent(
                            CrearCuentaEvent.OnApellidosChanged(it)
                        )
                    },
                    label = {
                        Text("Apellidos")
                    },
                    leadingIcon = {

                        Icon(
                            Icons.Default.Person,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                Spacer(Modifier.height(16.dp))

                //////////////////////////////////////////////////////
                // TELEFONO
                //////////////////////////////////////////////////////

                OutlinedTextField(
                    value = uiState.telefono,
                    onValueChange = {

                        viewModel.onEvent(
                            CrearCuentaEvent.OnTelefonoChanged(it)
                        )
                    },
                    label = {
                        Text("Teléfono")
                    },
                    leadingIcon = {

                        Icon(
                            Icons.Default.Phone,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
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

                        viewModel.onEvent(
                            CrearCuentaEvent.OnEmailChanged(it)
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
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                Spacer(Modifier.height(16.dp))

                //////////////////////////////////////////////////////
                // PASSWORD
                //////////////////////////////////////////////////////

                OutlinedTextField(
                    value = uiState.password,
                    onValueChange = {

                        viewModel.onEvent(
                            CrearCuentaEvent.OnPasswordChanged(it)
                        )
                    },
                    label = {
                        Text("Contraseña")
                    },
                    leadingIcon = {

                        Icon(
                            Icons.Default.Lock,
                            contentDescription = null
                        )
                    },
                    visualTransformation =
                        PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                Spacer(Modifier.height(16.dp))

                //////////////////////////////////////////////////////
                // REPETIR PASSWORD
                //////////////////////////////////////////////////////

                OutlinedTextField(
                    value = uiState.repetirPassword,
                    onValueChange = {

                        viewModel.onEvent(
                            CrearCuentaEvent
                                .OnRepetirPasswordChanged(it)
                        )
                    },
                    label = {
                        Text("Repetir contraseña")
                    },
                    leadingIcon = {

                        Icon(
                            Icons.Default.Lock,
                            contentDescription = null
                        )
                    },
                    visualTransformation =
                        PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                //////////////////////////////////////////////////////
                // ERROR
                //////////////////////////////////////////////////////

                uiState.errorMessage?.let {

                    Spacer(Modifier.height(18.dp))

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor =
                                Color.Red.copy(alpha = 0.2f)
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {

                        Text(
                            text = it,
                            color = Color.White,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

                Spacer(Modifier.height(30.dp))

                //////////////////////////////////////////////////////
                // BOTON CREAR
                //////////////////////////////////////////////////////

                Button(
                    onClick = {

                        viewModel.onEvent(
                            CrearCuentaEvent.OnConfirmarClick
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

                    if (uiState.isLoading) {

                        CircularProgressIndicator(
                            color = Color.White,
                            strokeWidth = 2.dp,
                            modifier = Modifier.size(24.dp)
                        )

                    } else {

                        Text(
                            text = "Crear cuenta",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(Modifier.height(14.dp))

                //////////////////////////////////////////////////////
                // CANCELAR
                //////////////////////////////////////////////////////

                TextButton(

                    onClick = {

                        onBack()
                    },

                    modifier = Modifier.align(
                        Alignment.CenterHorizontally
                    )
                ) {

                    Text(
                        text = "Cancelar",
                        color = Color.LightGray,
                        fontSize = 15.sp
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
fun PreviewCrearCuentaScreen() {

    CrearCuentaScreen(

        viewModel = CrearCuentaViewModel(),

        onBack = {}
    )
}
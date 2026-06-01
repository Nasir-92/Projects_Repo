package com.pmdm.ecobite.ui.features.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
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
fun LoginScreen(
    loginUiState: LoginUiState,
    onLoginEvent: (LoginEvent) -> Unit
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
                // FONDO
                //////////////////////////////////////////////////////

                Image(
                    painter = painterResource(R.drawable.fondo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(340.dp),
                    contentScale = ContentScale.Crop
                )

                //////////////////////////////////////////////////////
                // DEGRADADO
                //////////////////////////////////////////////////////

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(340.dp)
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
                // LOGO + TITULO
                //////////////////////////////////////////////////////

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier
                            .size(130.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(
                                id = R.drawable.logo
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(85.dp)
                        )
                    }

                    Spacer(Modifier.height(20.dp))

                    Text(
                        text = "EcoBite",
                        color = Color.White,
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(6.dp))

                    Text(
                        text = "Tu app eco-friendly favorita 🌱",
                        color = Color.LightGray,
                        fontSize = 16.sp
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
                // TITULO
                //////////////////////////////////////////////////////

                Text(
                    text = "🔐 Iniciar sesión",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(24.dp))

                //////////////////////////////////////////////////////
                // EMAIL
                //////////////////////////////////////////////////////

                OutlinedTextField(
                    value = loginUiState.email,
                    onValueChange = {
                        onLoginEvent(
                            LoginEvent.OnEmailChanged(it)
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

                Spacer(Modifier.height(18.dp))

                //////////////////////////////////////////////////////
                // PASSWORD
                //////////////////////////////////////////////////////

                OutlinedTextField(
                    value = loginUiState.password,
                    onValueChange = {
                        onLoginEvent(
                            LoginEvent.OnPasswordChanged(it)
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
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    visualTransformation =
                        PasswordVisualTransformation(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                Spacer(Modifier.height(28.dp))

                //////////////////////////////////////////////////////
                // BOTON LOGIN
                //////////////////////////////////////////////////////

                Button(
                    onClick = {
                        onLoginEvent(
                            LoginEvent.OnLoginClick
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
                        text = "Entrar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                //////////////////////////////////////////////////////
                // ERROR
                //////////////////////////////////////////////////////

                loginUiState.errorMessage?.let {

                    Spacer(Modifier.height(16.dp))

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

                Spacer(Modifier.height(32.dp))

                //////////////////////////////////////////////////////
                // OPCIONES
                //////////////////////////////////////////////////////

                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1E1E1E)
                    )
                ) {

                    Column {

                        LoginOptionItem(
                            texto = "📝 Crear cuenta"
                        ) {

                            onLoginEvent(
                                LoginEvent.OnCreateAccountClick
                            )
                        }

                        HorizontalDivider(
                            color = Color.DarkGray
                        )

                        LoginOptionItem(
                            texto = "🔑 Recuperar contraseña"
                        ) {

                            onLoginEvent(
                                LoginEvent.OnRecoverPasswordClick
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
fun LoginOptionItem(
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
fun PreviewLoginScreen() {

    LoginScreen(
        loginUiState = LoginUiState(
            email = "john@example.com",
            password = "123456"
        ),
        onLoginEvent = {}
    )
}
package com.pmdm.ecobite.data.mocks.usuario

import java.time.LocalDateTime

class UsuarioDaoMock {

    private val usuarios = mutableListOf(

        UsuarioMock(
            idUsuario = 1,
            nombre = "Carlos",
            apellidos = "Martinez",
            telefono = "600111222",
            email = "carlos@mail.com",
            password = "1234",
            rol = "CLIENTE",
            ubicacion = "Alicante",
            createdAt = LocalDateTime.now().toString()
        ),

        UsuarioMock(
            idUsuario = 2,
            nombre = "Laura",
            apellidos = "Gomez",
            telefono = "600222333",
            email = "laura@mail.com",
            password = "1234",
            rol = "CLIENTE",
            ubicacion = "Valencia",
            createdAt = LocalDateTime.now().toString()
        )
    )

    fun getAll(): List<UsuarioMock> = usuarios

    fun getById(id: Int): UsuarioMock? =
        usuarios.find { it.idUsuario == id }

    fun getByEmail(email: String): UsuarioMock? =
        usuarios.find { it.email == email }

    fun insert(usuario: UsuarioMock) {
        usuarios.add(usuario)
    }

    fun update(usuario: UsuarioMock) {
        val index = usuarios.indexOfFirst { it.idUsuario == usuario.idUsuario }
        if (index != -1) {
            usuarios[index] = usuario
        }
    }

    fun delete(id: Int) {
        usuarios.removeIf { it.idUsuario == id }
    }
}
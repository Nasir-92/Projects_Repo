
package com.pmdm.ecobite.network

import com.pmdm.ecobite.data.remote.dto.LoginDto
import com.pmdm.ecobite.data.remote.dto.UsuarioCreateDto

class RemoteRepository {

    suspend fun getRecetas() =
        RetrofitInstance.api.getRecetas()

    suspend fun getRestaurantes() =
        RetrofitInstance.api.getRestaurantes()

    suspend fun getUsuarios() =
        RetrofitInstance.api.getUsuarios()

    suspend fun crearUsuario(
        usuario: UsuarioCreateDto
    ) = RetrofitInstance.api.crearUsuario(usuario)

    suspend fun login(
        usuario: LoginDto
    ) =
        RetrofitInstance
            .api
            .login(usuario)
}

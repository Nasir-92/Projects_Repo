package com.pmdm.ecobite.data.mocks.usuario

import com.pmdm.ecobite.models.Usuario

class UsuarioRepository(
    private val dao: UsuarioDaoMock = UsuarioDaoMock()
) {

    fun getAll(): List<Usuario> =
        dao.getAll().toUsuarios()

    fun getById(id: Int): Usuario? =
        dao.getById(id)?.toUsuario()

    fun getByEmail(email: String): Usuario? =
        dao.getByEmail(email)?.toUsuario()

    fun insert(usuario: Usuario) {
        dao.insert(usuario.toUsuarioMock())
    }

    fun update(usuario: Usuario) {
        dao.update(usuario.toUsuarioMock())
    }

    fun delete(id: Int) {
        dao.delete(id)
    }

    fun login(email: String, password: String): Usuario? {

        val usuario = dao.getByEmail(email)

        return if (usuario?.password == password) usuario.toUsuario() else null
    }

    fun updatePassword(email: String, nuevaPassword: String) {

        val usuario = dao.getByEmail(email)

        if (usuario != null) {

            val usuarioActualizado = usuario.copy(
                password = nuevaPassword
            )

            dao.update(usuarioActualizado)
        }
    }
}
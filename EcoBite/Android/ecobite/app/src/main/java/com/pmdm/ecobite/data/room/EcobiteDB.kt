package com.pmdm.ecobite.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pmdm.ecobite.data.room.mensaje.Converters
import com.pmdm.ecobite.data.room.mensaje.MensajeDao
import com.pmdm.ecobite.data.room.mensaje.MensajeEntity
import com.pmdm.ecobite.data.room.receta.RecetaDao
import com.pmdm.ecobite.data.room.receta.RecetaEntity
import com.pmdm.ecobite.data.room.restaurante.RestauranteDao
import com.pmdm.ecobite.data.room.restaurante.RestauranteEntity
import com.pmdm.ecobite.data.room.usuario.UsuarioDao
import com.pmdm.ecobite.data.room.usuario.UsuarioEntity


@Database(
    entities = [MensajeEntity::class, RecetaEntity::class, RestauranteEntity::class, UsuarioEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class EcobiteDB : RoomDatabase() {
    abstract fun mensajeDao(): MensajeDao
    abstract fun recetaDao(): RecetaDao
    abstract fun restauranteDao(): RestauranteDao
    abstract fun usuarioDao(): UsuarioDao
    companion object {
        fun getDatabase(context: Context) = Room.databaseBuilder(
            context,
            EcobiteDB::class.java, "ecobite.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}
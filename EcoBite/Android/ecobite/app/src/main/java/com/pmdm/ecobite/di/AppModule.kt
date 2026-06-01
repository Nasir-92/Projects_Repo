package com.pmdm.ecobite.di

import android.content.Context
import com.pmdm.ecobite.data.room.EcobiteDB
import com.pmdm.ecobite.data.room.mensaje.MensajeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideEcobiteDatabase(
        @ApplicationContext context: Context
    ): EcobiteDB = EcobiteDB.getDatabase(context)


}
package com.rulhouse.datastorewithhilt.di

import android.content.Context
import com.rulhouse.datastorewithhilt.impl.SharedPreferenceImpl
import com.rulhouse.datastorewithhilt.repository.SharedPreferenceRepository
import com.rulhouse.datastorewithhilt.use_cases.GetFeverAlarm
import com.rulhouse.datastorewithhilt.use_cases.SetFeverAlarm
import com.rulhouse.datastorewithhilt.use_cases.SharedPreferenceUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferencesRepository(@ApplicationContext context: Context): SharedPreferenceRepository {
        return SharedPreferenceImpl(context)
    }

    @Provides
    @Singleton
    fun provideSharedPreferencesUseCases(repository: SharedPreferenceRepository): SharedPreferenceUseCases {
        return SharedPreferenceUseCases(
            getFeverAlarm = GetFeverAlarm(repository),
            setFeverAlarm = SetFeverAlarm(repository)
        )
    }
}
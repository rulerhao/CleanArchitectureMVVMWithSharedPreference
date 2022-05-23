package com.rulhouse.datastorewithhilt.repository

interface SharedPreferenceRepository {
    suspend fun setFeverAlarm(boolean: Boolean)
    suspend fun getFeverAlarm(): Boolean
}
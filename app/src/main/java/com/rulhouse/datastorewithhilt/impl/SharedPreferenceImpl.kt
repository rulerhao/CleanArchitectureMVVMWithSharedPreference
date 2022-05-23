package com.rulhouse.datastorewithhilt.impl

import android.content.Context
import com.rulhouse.datastorewithhilt.repository.SharedPreferenceRepository

class SharedPreferenceImpl (
    private val context: Context,
) : SharedPreferenceRepository {
    private val name = "Momisuresure"
    private val basalAlarmName = "basal_fever_alarm"

    val pref = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    override suspend fun getFeverAlarm(): Boolean {
        return pref.getBoolean(basalAlarmName, false)
    }

    override suspend fun setFeverAlarm(isOn: Boolean) {
        pref.edit().putBoolean(basalAlarmName, isOn).apply()
    }
}
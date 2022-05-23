package com.rulhouse.datastorewithhilt.use_cases

import com.rulhouse.datastorewithhilt.repository.SharedPreferenceRepository

class SetFeverAlarm (
    private val repository: SharedPreferenceRepository
) {
    suspend operator fun invoke(isOn: Boolean) {
        repository.setFeverAlarm(isOn)
    }
}
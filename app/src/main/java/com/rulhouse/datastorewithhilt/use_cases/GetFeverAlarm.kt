package com.rulhouse.datastorewithhilt.use_cases

import com.rulhouse.datastorewithhilt.repository.SharedPreferenceRepository

class GetFeverAlarm (
    private val repository: SharedPreferenceRepository
) {
    suspend operator fun invoke(): Boolean {
        return repository.getFeverAlarm()
    }
}
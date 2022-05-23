package com.rulhouse.datastorewithhilt.view

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rulhouse.datastorewithhilt.use_cases.SharedPreferenceUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val useCases: SharedPreferenceUseCases
) : ViewModel() {
    private val _feverAlarmState = mutableStateOf(false)
    val feverAlarmState: State<Boolean> = _feverAlarmState

    init {
        viewModelScope.launch {
            _feverAlarmState.value = useCases.getFeverAlarm()
        }
    }

    fun onEvent(event: MainScreenEvent) {
        when(event) {
            is MainScreenEvent.ToggleAlarm -> {
                viewModelScope.launch {
                    _feverAlarmState.value = !feverAlarmState.value
                    useCases.setFeverAlarm(feverAlarmState.value)
                }
            }
        }
    }
}
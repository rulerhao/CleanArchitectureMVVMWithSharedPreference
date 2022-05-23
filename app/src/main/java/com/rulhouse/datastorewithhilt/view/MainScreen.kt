package com.rulhouse.datastorewithhilt.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    Column(

    ) {
        Text(
            text = viewModel.feverAlarmState.value.toString()
        )
        Button(
            onClick = {
                viewModel.onEvent(MainScreenEvent.ToggleAlarm)
            }
        ) {
            Text(
                text = "Toggle alarm"
            )
        }
    }
}
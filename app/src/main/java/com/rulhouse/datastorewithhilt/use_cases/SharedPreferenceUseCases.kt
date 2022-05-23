package com.rulhouse.datastorewithhilt.use_cases

import com.rulhouse.datastorewithhilt.use_cases.GetFeverAlarm
import com.rulhouse.datastorewithhilt.use_cases.SetFeverAlarm

data class SharedPreferenceUseCases (
    val setFeverAlarm: SetFeverAlarm,
    val getFeverAlarm: GetFeverAlarm,
)

package com.example.basicstatemycode.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class WellnessTask(
    val id: Int,
    val label: String,
    var checked: MutableState<Boolean> = mutableStateOf(false)
)


/**
package com.example.basicstatemycode.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class WellnessTask(
val id: Int,
val label: String,
var initialChecked: Boolean = false
) {
var checked by mutableStateOf(initialChecked)
}
 */
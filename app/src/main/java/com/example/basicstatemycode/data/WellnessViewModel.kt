package com.example.basicstatemycode.data

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _task =
        getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _task

    fun remove(item: WellnessTask) {
        _task.remove(item)
    }

    fun changeTaskChecked(
        item: WellnessTask,
        checked: Boolean
    ) {
        tasks.find { it.id == item.id }?.let { task->
            task.checked.value = checked
        }
    }
}

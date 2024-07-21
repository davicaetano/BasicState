package com.davicaetano.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    list: List<WellnessTask> = rememberSaveable { getWellnessTasksList() },
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(list) { item ->
            WellnessTaskItem(taskName = item.label)
        }
    }
}

fun getWellnessTasksList() = List(30) { i -> WellnessTask(i, "Task # $i")}
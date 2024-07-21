package com.davicaetano.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ) { item ->
            WellnessTaskItem(
                taskName = item.label,
                onClose = { onCloseTask(item) },
            )
        }
    }
}

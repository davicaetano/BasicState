package com.davicaetano.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    val list = remember { getWellnessTasksList().toMutableStateList() }

    Column(modifier) {
        StatefulCounter()
        WellnessTasksList(
            list = list,
            onCloseTask = { wellnessTask -> list.remove(wellnessTask) }
        )
    }
}

fun getWellnessTasksList() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }

}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count = count, onIncrement = { count++ })
}

@Preview(showBackground = true)
@Composable
fun PreviewWellnessScreen() {
    WellnessScreen(Modifier)
}

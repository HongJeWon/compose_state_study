package com.example.basicstatemycode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstatemycode.data.WellnessTasksList
import com.example.basicstatemycode.data.WellnessViewModel
import com.example.basicstatemycode.data.getWellnessTasks
import com.example.basicstatemycode.ui.theme.BasicStateMyCodeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateMyCodeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var waterCount by remember { mutableStateOf(0) }
    Column {
        StatelessCounter(
            count = waterCount,
            onIncrement = { waterCount++ })
    }
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember {
            mutableStateOf(0)
        }
        if (count > 0) {
            var count by remember { mutableStateOf(0) }
            if (count > 0) {
                Text("You've had $count glasses.")
            }
            Button(
                onClick = { count++ },
                Modifier.padding(top = 8.dp),
                enabled = count < 10
            ) {
                Text("Add one")
            }
        }
    }
}

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {

    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { wellnessTask, checked ->
                wellnessViewModel.changeTaskChecked(
                    wellnessTask,
                    checked
                )
            },
            onCloseTask = { wellnessTask -> wellnessViewModel.remove(wellnessTask) }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreViewWellnessScreen() {
    Surface {
        WellnessScreen()
    }
}
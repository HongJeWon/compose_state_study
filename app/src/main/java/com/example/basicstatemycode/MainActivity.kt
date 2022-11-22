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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun WaterCounter(modifier: Modifier = Modifier) {
    val count = 0
    Column {
        Text(
            text = "you've had $count glasses",
            modifier = modifier.padding(16.dp)
        )
        Button(onClick = {}, modifier = Modifier.padding(top = 8.dp)) {
            Text(text = "Add one")
        }
    }

}

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    WaterCounter()
}

@Preview(showBackground = true)
@Composable
fun PreViewWellnessScreen() {
    Surface {
        WellnessScreen()
    }
}
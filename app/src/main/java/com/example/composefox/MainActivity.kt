package com.example.composefox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.composefox.ui.theme.ComposeFoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                        //.padding(all = 59.dp),
                    color = MaterialTheme.colors.primary
                ) {Column() {
                    Greeting("Android")
                    showAge()
                }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun showAge(age: Int = 12) {
    Text(text = age.toString())
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeFoxTheme {
        Column() {
            Greeting("Android")
            showAge()
        }
    }
}
package com.example.composefox

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefox.ui.theme.ComposeFoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFoxTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    val moneyC = remember {
        mutableStateOf(0)
    }
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        color = Color(0xFFFFDDD2)
    ) {
        Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = moneyC.value.toString() , style = TextStyle(color = Color.White,
                fontSize = 35.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(50.dp))
            CreateCircle(moneyCount = moneyC.value){newValue ->
                moneyC.value = newValue
            }
        }
    }
}

@Composable
fun CreateCircle(moneyCount : Int = 0, updateMoneyCounter: (Int) -> Unit) {
//    var moneyCounter by remember {
//        mutableStateOf(0)
//    }
        Card(
            modifier = Modifier
                .padding(3.dp)
                .size(105.dp)
                .clickable {
                    Log.d("Tap", moneyCount.toString())
                    updateMoneyCounter(moneyCount + 1)
                },
            shape = CircleShape,
            elevation = 4.dp
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = "Tap", modifier = Modifier)
            }
        }
    }
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeFoxTheme {
        MyApp()
    }
}
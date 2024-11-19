package com.santy.examenej2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorSelectionApp()
        }
    }
}


@Composable
fun ColorSelectionApp() {
    var selectedColor by remember { mutableStateOf(Color.Gray) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ColorPicker(
            colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan),
            onColorSelected = { color -> selectedColor = color }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(selectedColor),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Color", color = Color.White)
        }
    }
}


@Composable
fun ColorPicker(colors: List<Color>, onColorSelected: (Color) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        colors.forEach { color ->

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color)
                    .clickable { onColorSelected(color) }
            )
        }
    }
}

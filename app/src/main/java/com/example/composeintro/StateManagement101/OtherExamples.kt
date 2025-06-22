package com.example.composeintro.StateManagement101

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.composeintro.R

@Composable
fun OtherExamples(){
    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var userInput = remember{ mutableStateOf("") }
        var textVal = remember{ mutableStateOf("Merhaba Android") }
        var paddingVal = remember{ mutableStateOf(10.dp) }
        TextField(
            value = userInput.value,
            onValueChange = {
                userInput.value = it
                println(it)
            },
            placeholder = {
                Text("name")
            }

        )
        Spacer(modifier = Modifier.padding(paddingVal.value))
        Text(textVal.value)
        Button(onClick = {
            textVal.value = "Merhaba Bilal"
            paddingVal.value = 20.dp
        }) {
            Text("Login")
        }

        Spacer(modifier = Modifier.padding(paddingVal.value))
        Image(bitmap = ImageBitmap.imageResource(id = R.drawable.bursa),
            contentDescription = "bursa",
            modifier = Modifier.size(350.dp, 220.dp)
        )
        Image(painter = ColorPainter(Color.Red), contentDescription = "black", modifier = Modifier.size(100.dp, 100.dp))
    }

}
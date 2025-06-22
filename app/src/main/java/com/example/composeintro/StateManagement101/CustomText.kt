package com.example.composeintro.StateManagement101

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomText(text: String) {
    Text(modifier = Modifier.clickable{
        println("texte tıklandı")
    }
        .background(Color.Red)
        .fillMaxWidth(0.9f )
        .padding(10.dp),
        text = text
    )
}

@Preview(showBackground = true)
@Composable
fun CustomPreview(){
    CustomText(text="Custom Text")
}
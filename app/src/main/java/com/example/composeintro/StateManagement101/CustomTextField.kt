package com.example.composeintro.StateManagement101

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(string: String, placeHolder: String ,onValueChangeFunction: ((String) -> Unit)) {
    TextField(
        placeholder = {
            Text(text = placeHolder)
        },
        value = string, onValueChange = {
            onValueChangeFunction
        })
}

@Composable
fun CustText(string : String){
    Text(text = string,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Italic
    )
}

@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview(){
    CustomTextField(
        string = "Hello World",
        placeHolder = "Enter text",
        onValueChangeFunction = { newText -> println(newText) }
    )
}

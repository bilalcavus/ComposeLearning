package com.example.composeintro

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeintro.ui.theme.ComposeIntroTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeIntroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        MainScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(){
    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustText("Merhaba Android")
            Spacer(modifier = Modifier.padding(10.dp))
            CustText("MErhanba Bilal")
            Spacer(modifier  = Modifier.padding(10.dp))
            CustText("Merhaba ÇAvuş")
    }

}

@Composable
fun CustomTextField(string: String){
    var myState = remember { mutableStateOf(string) }
    TextField(value = myState.value, onValueChange = {
        myState.value = it
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
fun GreetingPreview() {
    ComposeIntroTheme {
        MainScreen()
    }
}
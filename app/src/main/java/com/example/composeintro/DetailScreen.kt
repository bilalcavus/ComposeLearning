package com.example.composeintro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeintro.model.Food
import com.example.composeintro.ui.theme.ComposeIntroTheme


@Composable
fun DetailScreen(food: Food){
    Box(modifier = Modifier.fillMaxSize()
        .background(color = MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ){
        Column {
            Text(food.name,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Image(bitmap = ImageBitmap.imageResource(id = food.image),
                contentDescription = food.name,
                modifier = Modifier.padding(10.dp)
                    .size(300.dp, 200.dp)
            )

            Text(food.ingredients,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(5.dp),
                textAlign = TextAlign.Center
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodListPreview() {
    ComposeIntroTheme {
        val pizza = Food(
            name = "Pizza",
            ingredients = "Tomato, Cheese, Pepperoni",
            image = R.drawable.pizza
        )
        val makarna = Food(
            name = "Makarna",
            ingredients = "Un, Su, Tuz",
            image = R.drawable.makarna
        )
        val kofte = Food(
            name = "Köfte",
            ingredients = "Kıyma, Soğan, Baharatlar",
            image = R.drawable.kofte
        )
        val salata = Food(
            name = "Salata",
            ingredients = "Marul, Domates, Salatalık",
            image = R.drawable.salata
        )
        val ekmek = Food(
            name = "Ekmek",
            ingredients = "Un, Su, Tuz",
            image = R.drawable.ekmek
        )

        DetailScreen(food = pizza)
    }
}
package com.example.composeintro

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeintro.StateManagement101.CustomText
import com.example.composeintro.StateManagement101.StateManagementIntro
import com.example.composeintro.model.Food
import com.example.composeintro.ui.theme.ComposeIntroTheme
import com.google.gson.Gson

@Composable
fun FoodList(foods : List<Food>, navController: NavController){
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.primary),
        contentPadding =  PaddingValues(5.dp),

        ) {
            items(foods){
                FoodDetails(it, navController = navController)
            }
    }
}

@Composable
fun FoodDetails(food: Food, navController: NavController){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primary)
        .clickable {
            navController.navigate("detail_screen/${Gson().toJson(food)}")
        }) {
        Text(text= food.name,
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold
        
        )
        Text(food.ingredients)
    }
}

/*
@Preview(showBackground = true)
@Composable
fun FoodListPreview() {
    ComposeIntroTheme {
        val foodList = arrayListOf<Food>()
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

        foodList.add(pizza)
        foodList.add(makarna)
        foodList.add(kofte)
        foodList.add(salata)
        foodList.add(ekmek)
        FoodList(foodList)
    }
}
 */
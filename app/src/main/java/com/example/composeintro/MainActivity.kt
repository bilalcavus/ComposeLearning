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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeintro.StateManagement101.CustText
import com.example.composeintro.StateManagement101.CustomTextField
import com.example.composeintro.StateManagement101.StateManagementIntro
import com.example.composeintro.model.Food
import com.example.composeintro.ui.theme.ComposeIntroTheme
import com.google.gson.Gson
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {

    private val foodList = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            ComposeIntroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        NavHost(
                            navController = navController ,
                            startDestination = "list_screen",
                        ){
                            composable("list_screen"){
                                initFoodList()
                                FoodList(foods = foodList, navController)
                            }
                            composable("detail_screen/{selectedFood}", arguments = listOf(
                                navArgument("selectedFood"){
                                    type = NavType.StringType
                                }
                            )){
                                val foodString = remember{
                                    it.arguments?.getString("selectedFood")
                                }
                                val selectedFood = Gson().fromJson(foodString, Food::class.java)
                                DetailScreen(selectedFood)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun initFoodList() {
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
    }
}


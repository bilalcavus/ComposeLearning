package com.example.composeintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeintro.ComposeRetfrofit.model.User
import com.example.composeintro.ComposeRetfrofit.view.UserDetail
import com.example.composeintro.ComposeRetfrofit.view.UserList
import com.example.composeintro.ComposeRetfrofit.viewmodel.UserViewModel
import com.example.composeintro.LazyColumnExample.model.Food
import com.example.composeintro.ui.theme.ComposeIntroTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    private val viewModel : UserViewModel by viewModels<UserViewModel>()
    private val foodList = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ComposeIntroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        /*
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
                        */
                        viewModel.fetchUsers()
                        NavHost(
                            navController = navController,
                            startDestination = "user_list_screen",
                        ){
                            composable("user_list_screen") {
                                UserList(viewModel.users.value, navController)
                            }
                            composable("user_detail_screen/{selectedUser}", arguments = listOf(
                                navArgument("selectedUser"){
                                    type = NavType.StringType
                                }
                            )){
                                val userString = remember {
                                    it.arguments?.getString("selectedUser")
                                }
                                val selectedUser = Gson().fromJson(userString, User::class.java)
                                UserDetail(user = selectedUser)
                            }
                        }


                    }
                }
            }
        }
    }
}


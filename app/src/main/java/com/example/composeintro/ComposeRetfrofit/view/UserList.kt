package com.example.composeintro.ComposeRetfrofit.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeintro.ComposeRetfrofit.model.User
import com.example.composeintro.ui.theme.ComposeIntroTheme
import com.google.gson.Gson

@Composable
fun UserList(users : List<User>, navController: NavController){
   LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(10.dp)) {
       items(users) {
           UserDetails(it, navController = navController)
       }
   }
}

@Composable
fun UserDetails(user: User, navController: NavController){
    Column(
        modifier = Modifier.fillMaxWidth()
            .border(BorderStroke(2.dp, Color.Black))
            .background(color = Color.LightGray)
            .padding(10.dp)
            .clickable {
                navController.navigate("user_detail_screen/${Gson().toJson(user)}")
            }

    ) {
        Column {
            Text(user.name, fontWeight = FontWeight.Bold, modifier = Modifier.padding(2.dp))
            Spacer(modifier = Modifier.padding(4.dp))
            Text("Email: ${user.email}")
            Text("Username: ${user.username}")
            Text("Phone: ${user.phone}")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun UserPreview(){
     ComposeIntroTheme {

     }
}
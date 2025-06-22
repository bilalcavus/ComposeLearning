package com.example.composeintro.LazyColumnExample.data

import com.example.composeintro.LazyColumnExample.model.Food
import com.example.composeintro.R

fun initFoodList() {
    val foodList = mutableListOf<Food>()
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
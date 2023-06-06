//package com.foodtracker.app.presentation.diary
//
//import com.foodtracker.app.domain.model.*
//import java.lang.RuntimeException
//
//class ItemMapper {
//    fun mapApiToUi(api: FoodApi): Item = when {
//        api.isProduct != null -> Product(
//            id = api.id,
//            name = api.name,
//            kcal = api.kcal,
//            proteins = api.proteins,
//            carbs = api.carbs,
//            fats = api.fats,
//            custom = api.custom ?: true,
//            isProduct = true
//        )
//        api.isFood != null -> Food(
//            id = api.id,
//            name = api.name,
//            kcal = api.kcal,
//            proteins = api.proteins,
//            carbs = api.carbs,
//            fats = api.fats,
//            isFood = true
//        )
//        api.isMeal != null -> Meal(
//            id = api.id,
//            name = api.name,
//            kcal = api.kcal,
//            proteins = api.proteins,
//            carbs = api.carbs,
//            fats = api.fats,
//            isMeal = true
//        )
//        api.isAddProduct != null -> AddProduct(
//            id = api.id,
//            name = api.name,
//            kcal = api.kcal,
//            proteins = api.proteins,
//            carbs = api.carbs,
//            fats = api.fats,
//            isAddProduct = true
//        )
//        api.isAddFood != null -> AddFood(
//            id = api.id,
//            name = api.name,
//            kcal = api.kcal,
//            proteins = api.proteins,
//            carbs = api.carbs,
//            fats = api.fats,
//            isAddFood = true
//        )
//        api.isAddMeal != null -> AddMeal(
//            id = api.id,
//            name = api.name,
//            kcal = api.kcal,
//            proteins = api.proteins,
//            carbs = api.carbs,
//            fats = api.fats,
//            isAddMeal = true
//        )
//        else -> throw RuntimeException("map Api to Ui")
//    }
//}
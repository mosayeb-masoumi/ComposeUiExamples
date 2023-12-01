package com.example.compose_ui_examples.composables.ObjectArrayBetweenScreens.destination

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.compose_ui_examples.composables.ObjectArrayBetweenScreens.screens.FirstObjectArrayScreen
import com.example.compose_ui_examples.composables.ObjectArrayBetweenScreens.screens.MyModel
import com.example.compose_ui_examples.composables.ObjectArrayBetweenScreens.screens.SecondObjectArrayScreen
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


sealed class DestinationObjectArray(var route: String ){

    object First: DestinationObjectArray("first")
    object Second: DestinationObjectArray("second/{myModelJson}/{myListJson}"){
        fun createRoute(myModelJson: String , myListJson: String) = "second/$myModelJson/$myListJson"
    }

}

@Composable
fun NavigationAppHostObjectArray(navController: NavHostController) {


    NavHost(navController, startDestination = DestinationObjectArray.First.route) {


        composable(DestinationObjectArray.First.route) {
            FirstObjectArrayScreen(navController)
        }

        composable(DestinationObjectArray.Second.route , arguments = listOf(

                navArgument("myModelJson"){type = NavType.StringType},
                navArgument("myListJson"){type = NavType.StringType},

        )){ backStackEntry ->
            val myModelJson = backStackEntry.arguments?.getString("myModelJson")
            val myModel = Gson().fromJson(myModelJson, MyModel::class.java)

            val myListJson = backStackEntry.arguments?.getString("myListJson")
            val myListType = object : TypeToken<List<MyModel>>() {}.type
            val myList = Gson().fromJson<List<MyModel>>(myListJson, myListType)
            SecondObjectArrayScreen(navController , myModel , myList)
        }




    }
}
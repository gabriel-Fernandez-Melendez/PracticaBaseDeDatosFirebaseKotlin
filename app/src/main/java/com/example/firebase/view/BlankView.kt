package com.example.firebase.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.firebase.model.Routes
import com.google.firebase.auth.FirebaseAuth

@Composable
fun BlankView(navController: NavController){

    LaunchedEffect(Unit){
        if (!FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()){
            navController.navigate(Routes.Home.route)
        }else{
            navController.navigate(Routes.Login.route)
        }
    }

}
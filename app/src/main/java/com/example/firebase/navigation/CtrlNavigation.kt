package com.example.firebase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.firebase.model.Routes
import com.example.firebase.view.AddNoteView
import com.example.firebase.view.BlankView
import com.example.firebase.view.EditNoteView
import com.example.firebase.view.HomeView
import com.example.firebase.view.TabsView
import com.example.firebase.viewmodel.LoginViewModel
import com.example.firebase.viewmodel.NotesViewModel


@Composable
fun CtrlNavigation(loginVM : LoginViewModel, notesVM : NotesViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Blank.route) {
        composable(Routes.Blank.route) {
            BlankView(navController)
        }
        composable(Routes.Login.route) {
            TabsView(navController, loginVM)
        }
        composable(Routes.Home.route) {
            HomeView(navController,notesVM)
        }
      composable(Routes.AddNote.route) {
                AddNoteView(navController, notesVM)
          }
         composable(
           Routes.EditNote.route,
         arguments = listOf(navArgument("idDoc") { type = NavType.StringType })
             ) {
               val idDoc = it.arguments?.getString("idDoc") ?: ""
             EditNoteView(navController, notesVM, idDoc)
        }

    }
}

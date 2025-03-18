package com.example.firebase.model


// Definición de las rutas con una sealed class

sealed class Routes(val route: String) {
    object Blank : Routes("Blank")
    object Login : Routes("Login")
    object Home : Routes("Home")
    object AddNote : Routes("AddNoteView")
    object EditNote : Routes("EditNoteView/{idDoc}") {
        fun createRoute(idDoc: String) = "EditNoteView/$idDoc"

    }
}

package com.nv.medapp.navigation

sealed class Screen(val route: String) {
    object Intro : Screen("intro")
    object Details : Screen("detail")
    object Home : Screen("home")
    object TopDoctors : Screen("topDoctors")
}
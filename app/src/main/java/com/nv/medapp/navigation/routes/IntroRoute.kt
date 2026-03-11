package com.nv.medapp.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nv.medapp.feature.intro.IntroScreen
import com.nv.medapp.navigation.Screen

fun NavGraphBuilder.introRoute(
    onStart: () -> Unit
) {
    composable(route = Screen.Intro.route) {
        IntroScreen(onStartClick = onStart)
    }
}
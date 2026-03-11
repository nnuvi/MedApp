package com.nv.medapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.nv.medapp.core.viewModel.MainViewModel
import com.nv.medapp.navigation.routes.detailRoute
import com.nv.medapp.navigation.routes.homeRoute
import com.nv.medapp.navigation.routes.introRoute
import com.nv.medapp.navigation.routes.topDoctorsRoute

@Composable
fun AppNavGraph(
    nav: NavHostController,
    vm: MainViewModel,
){
    NavHost(navController = nav, startDestination = Screen.Intro.route) {
        introRoute(
            onStart = {
                nav.navigate(Screen.Home.route) {
                    popUpTo(Screen.Intro.route) {
                        inclusive = true
                    }
                }
            }
        )
        homeRoute(
            vm = vm,
            onOpenDetail = { doctorModel ->
                    nav.navigateToDetail(doctorModel, vm)
            },
            onOpenTopDoctors = {
                nav.navigate(Screen.TopDoctors.route)
            }
        )

        topDoctorsRoute(
            vm = vm,
            onBack = { nav.popBackStack() },
            onOpenDetail = { doctorModel ->
                nav.navigateToDetail(doctorModel, vm)
            }
        )

        detailRoute(
            nav = nav,
            vm = vm,
            onBack = { nav.popBackStack() }
        )
    }
}

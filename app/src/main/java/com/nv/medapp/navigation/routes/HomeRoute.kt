package com.nv.medapp.navigation.routes

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nv.medapp.core.model.DoctorModel
import com.nv.medapp.core.viewModel.MainViewModel
import com.nv.medapp.feature.home.MainScreen
import com.nv.medapp.navigation.Screen

fun NavGraphBuilder.homeRoute(
    vm: MainViewModel,
    onOpenDetail: (DoctorModel) -> Unit,
    onOpenTopDoctors: () -> Unit
) {
    composable ( route = Screen.Home.route ) {
        val categories by vm.categories.observeAsState(initial = emptyList())
        val doctors by vm.doctors.observeAsState(initial = emptyList())

        LaunchedEffect(Unit) {
            if (categories.isEmpty()) {
                vm.loadCategories()
            }
            if (doctors.isEmpty()) {
                vm.loadDoctors()
            }
        }
        MainScreen(
            viewModel = vm,
            onOpenDoctorDetail = onOpenDetail,
            onOpenTopDoctors = onOpenTopDoctors
        )
    }
}
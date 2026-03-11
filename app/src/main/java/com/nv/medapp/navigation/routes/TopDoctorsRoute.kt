package com.nv.medapp.navigation.routes

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nv.medapp.core.model.DoctorModel
import com.nv.medapp.core.viewModel.MainViewModel
import com.nv.medapp.feature.topDoctors.TopDoctorScreen
import com.nv.medapp.navigation.Screen

fun NavGraphBuilder.topDoctorsRoute(
    vm: MainViewModel,
    onBack: () -> Unit,
    onOpenDetail: (DoctorModel) -> Unit
) {
    composable(route = Screen.TopDoctors.route) {
        val doctors by vm.doctors.observeAsState(initial = emptyList())

        LaunchedEffect(Unit) {
            if (doctors.isEmpty()) {
                vm.loadDoctors()
            }
        }

        TopDoctorScreen(
            doctors = doctors,
            onBack = onBack,
            onOpendetail = onOpenDetail
        )
    }
}
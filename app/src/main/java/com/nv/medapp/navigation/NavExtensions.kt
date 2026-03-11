package com.nv.medapp.navigation

import androidx.navigation.NavController
import com.nv.medapp.core.model.DoctorModel
import com.nv.medapp.core.viewModel.MainViewModel

fun NavController.navigateToDetail(doctor: DoctorModel, vm: MainViewModel) {
    vm.selectDoctor(doctor)
    navigate(Screen.Details.route)
}
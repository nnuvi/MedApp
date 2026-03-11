package com.nv.medapp.navigation.routes

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.nv.medapp.core.model.DoctorModel
import com.nv.medapp.core.viewModel.MainViewModel
import com.nv.medapp.feature.detail.DetailScreen
import com.nv.medapp.feature.home.MainScreen
import com.nv.medapp.navigation.Screen
import androidx.core.net.toUri

//fun NavGraphBuilder.detailRoute(
//    nav: NavHostController,
//    onBack: ()-> Unit
//) {
//    composable ( route = Screen.Details.route ) {
//        backStackEntry: NavBackStackEntry ->
//        val context = LocalContext.current
//        val prevEntry = remember { nav.previousBackStackEntry }
////        val doctor = remember {
////            prevEntry?.savedStateHandle?.get<DoctorModel>("doctor")
////        }
//        val doctor =
//            nav.previousBackStackEntry
//                ?.savedStateHandle
//                ?.get<DoctorModel>("doctor")
//        LaunchedEffect(doctor) {
//            if(doctor == null) {
//                onBack()
//            } else {
//                prevEntry?.savedStateHandle?.remove<DoctorModel>("doctor")
//            }
//        }
//
//        if(doctor !== null) {
//            DetailScreen(
//                item = doctor,
//                onBack = onBack,
//                onOpenWebsite = {url->
//                    context.startActivity(
//                        Intent(Intent.ACTION_VIEW, url.toUri())
//                    )
//                },
//                onSendSms = { mobile, body ->
//                    context.startActivity(
//                        Intent(Intent.ACTION_VIEW, "sms:$mobile".toUri())
//                            .apply { putExtra("sms_body", body) }
//                    )
//                },
//                onDial = { mobile ->
//                    context.startActivity(
//                        Intent(Intent.ACTION_DIAL, "tel:$mobile".toUri())
//                    )
//                },
//                onDirection = { loc ->
//                    context.startActivity(
//                        Intent(Intent.ACTION_VIEW, "geo:0,0?q=$loc".toUri())
//                    )
//                },
//                onShare = { subject, text ->
//                    context.startActivity(
//                        Intent.createChooser(
//                            Intent(Intent.ACTION_SEND)
//                                .apply {
//                                    type = "text/plain"
//                                    putExtra(Intent.EXTRA_SUBJECT, subject)
//                                    putExtra(Intent.EXTRA_TEXT, text)
//                                },
//                            "choose one"
//                        )
//                    )
//                }
//            )
//        } else {
//            Spacer(Modifier.height(1.dp))
//        }
//    }
//}

fun NavGraphBuilder.detailRoute(
    nav: NavHostController,
    vm: MainViewModel,
    onBack: () -> Unit
) {
    composable(route = Screen.Details.route) {

        val context = LocalContext.current
        val doctor by vm.selectedDoctor.observeAsState()

        if (doctor == null) {
            LaunchedEffect(Unit) { onBack() }
            return@composable
        }

        DetailScreen(
            item = doctor!!,
            onBack = onBack,
            onOpenWebsite = { url ->
                context.startActivity(
                    Intent(Intent.ACTION_VIEW, url.toUri())
                )
            },
            onSendSms = { mobile, body ->
                context.startActivity(
                    Intent(Intent.ACTION_VIEW, "sms:$mobile".toUri()).apply {
                        putExtra("sms_body", body)
                    }
                )
            },
            onDial = { mobile ->
                context.startActivity(
                    Intent(Intent.ACTION_DIAL, "tel:$mobile".toUri())
                )
            },
            onDirection = { loc ->
                context.startActivity(
                    Intent(Intent.ACTION_VIEW, "geo:0,0?q=$loc".toUri())
                )
            },
            onShare = { subject, text ->
                context.startActivity(
                    Intent.createChooser(
                        Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_SUBJECT, subject)
                            putExtra(Intent.EXTRA_TEXT, text)
                        },
                        "choose one"
                    )
                )
            }
        )
    }
}
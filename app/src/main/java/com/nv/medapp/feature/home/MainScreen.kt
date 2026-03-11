package com.nv.medapp.feature.home

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.nv.medapp.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nv.medapp.core.model.DoctorModel
import com.nv.medapp.core.viewModel.MainViewModel
import com.nv.medapp.feature.intro.IntroScreen


@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onOpenDoctorDetail: (DoctorModel) -> Unit,
    onOpenTopDoctors: () -> Unit
) {
    val categories by viewModel.categories.observeAsState(emptyList())
    val doctors by viewModel.doctors.observeAsState(emptyList())


    LaunchedEffect(Unit) {
        if(categories.isEmpty()) viewModel.loadCategories()
        if(doctors.isEmpty()) viewModel.loadDoctors()
    }

    var selectedBottom by remember { mutableStateOf(0) }

    Scaffold(
        containerColor = colorResource(R.color.white),
        bottomBar = {
            HomeBottomBar(
                selected = selectedBottom,
                onSelect = { selectedBottom = it }
            )
        }
    ) { inner ->
        LazyColumn(contentPadding = inner) {
            item { HomeHeader() }
            item { Banner() }
            item { SectionHeader(title = "Doctor Speciality", onSeeAll = {}) }
            item { CategoryRow(items = categories, onClick = {}) }
            item { SectionHeader(title = " TopDoctors", onSeeAll = onOpenTopDoctors) }
            item { DoctorRow(items = doctors, onClick = onOpenDoctorDetail) }
        }
    }
}

//@Preview
//@Composable
//fun HomeScreenPreview(){
//    HomeScreen(
//        viewModel = MainViewModel()
//    )
//}
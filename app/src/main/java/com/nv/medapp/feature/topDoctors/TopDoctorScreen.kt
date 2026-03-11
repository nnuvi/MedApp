package com.nv.medapp.feature.topDoctors

import android.R.attr.numStars
import android.content.res.ColorStateList
import android.widget.RatingBar
import android.R as AndroidR
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextDirection
import com.nv.medapp.core.model.DoctorModel
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.nv.medapp.R
import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.nv.medapp.feature.detail.components.ActionItem
import com.nv.medapp.feature.detail.components.RatingState
import com.nv.medapp.feature.detail.components.StateColumn
import com.nv.medapp.feature.detail.components.VerticalDivider

@Composable
fun TopDoctorScreen(
    doctors:List<DoctorModel>,
    onBack: () -> Unit,
    onOpendetail: (DoctorModel) -> Unit,
    isLoading: Boolean = false
) {
    val listState = rememberLazyListState()

    Box(Modifier.fillMaxSize()) {
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(56.dp)
                ) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        text = "Top Doctors",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            items(
                items = doctors,
                key = { it.name + "_" + it.mobile + "" }
            ) { item ->
                DoctorRowCard(
                    item = item,
                    onMakeClick = { onOpendetail(item) }
            )
        }
    }
    when {
            isLoading -> {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        doctors.isEmpty() -> {
            Text(
                text = "It's Empty",
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        }



}
}

@Preview(showBackground = true)
@Composable
fun TopDoctorScreenPreview() {

    val sampleDoctors = listOf(
        DoctorModel(
            name = "Dr. John Smith",
            special = "Cardiologist",
            mobile = "123456789",
            picture = "",
            site = "",
            location = "City Hospital",
            patients = "1200",
            experience = 10,
            rating = 4.5
        ),
        DoctorModel(
            name = "Dr. Sarah Lee",
            special = "Dermatologist",
            mobile = "987654321",
            picture = "",
            site = "",
            location = "Health Clinic",
            patients = "900",
            experience = 8,
            rating = 4.2
        )
    )

    TopDoctorScreen(
        doctors = sampleDoctors,
        onBack = {},
        onOpendetail = {}
    )
}
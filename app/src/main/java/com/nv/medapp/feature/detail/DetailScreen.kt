package com.nv.medapp.feature.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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
import coil.compose.AsyncImage

@Composable
//fun DetailScreen(
//    item: DoctorModel,
//    onBack: () -> Unit,
//    onOpenWebsite: (String) -> Unit,
//    onSendSms: (mobile: String, body: String) -> Unit,
//    onDial: (mobile: String) -> Unit,
//    onDirection: (locationUrl: String) -> Unit,
//    onShare: (subject: String, text: String) -> Unit,
//){
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//    ) {
//        Box(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            DetailHeader(
//                pictureUrl = item.picture,
//                onBack = onBack
//            )
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 400.dp),
//                color = Color.White,
//                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
//            ) {
//                DetailBody(
//                    item = item,
//                    onOpenWebsite = onOpenWebsite,
//                    onSendSms = onSendSms,
//                    onDial = onDial,
//                    onDirection = onDirection,
//                    onShare = onShare
//                )
//            }
//        }
//    }
//}

fun DetailScreen(
    item: DoctorModel,
    onBack: () -> Unit,
    onOpenWebsite: (String) -> Unit,
    onSendSms: (mobile: String, body: String) -> Unit,
    onDial: (mobile: String) -> Unit,
    onDirection: (locationUrl: String) -> Unit,
    onShare: (subject: String, text: String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            DetailHeader(
                pictureUrl = item.picture,
                onBack = onBack
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 400.dp),
                color = Color.White,
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
            ) {
                DetailBody(
                    item = item,
                    onOpenWebsite = onOpenWebsite,
                    onSendSms = onSendSms,
                    onDial = onDial,
                    onDirection = onDirection,
                    onShare = onShare
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {

    val sampleDoctor = DoctorModel(
        name = "Dr. John Smith",
        special = "Cardiologist",
        location = "New York Medical Center",
        patients = "1200+",
        experience = 12,
        rating = 4.8,
        picture = ""
    )

    DetailScreen(
        item = sampleDoctor,
        onBack = {},
        onOpenWebsite = {},
        onSendSms = { _, _ -> },
        onDial = {},
        onDirection = {},
        onShare = { _, _ -> }
    )
}
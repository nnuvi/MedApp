package com.nv.medapp.feature.detail

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
import com.nv.medapp.feature.detail.components.ActionItem
import com.nv.medapp.feature.detail.components.RatingState
import com.nv.medapp.feature.detail.components.StateColumn
import com.nv.medapp.feature.detail.components.VerticalDivider

@Composable
fun DetailBody(
    item: DoctorModel,
    onOpenWebsite: (String) -> Unit,
    onSendSms: (mobile: String, body: String) -> Unit,
    onDial: (mobile: String) -> Unit,
    onDirection: (locationUrl: String) -> Unit,
    onShare: (subject: String, text: String) -> Unit
) {
    val darkBlue = colorResource(R.color.catalina_blue)
    val lightBlue = colorResource(R.color.diamond_blue)
    val gray = colorResource(R.color.medium_gray)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Spacer(Modifier.height(24.dp))
        Text(
            text = item.name,
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
//            fontFamily = FontFamily(Font(R.font.dm_sans)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Text(
            text = item.special,
            color = Color.Black,
//            fontFamily = FontFamily(Font(R.font.dm_sans)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.location),
                contentDescription = null
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = item.location,
                color = darkBlue,
                fontSize = 16.sp,
//                fontFamily = FontFamily(Font(R.font.dm_sans)),
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            StateColumn(title = "Patients", value = item.patients)
            VerticalDivider(color = gray)
            StateColumn(title = "Experience", value = item.experience.toString())
            VerticalDivider(color = gray)
            RatingState(title = "Rating", rating = item.rating)
        }
        Text(
            text = "Biography",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )
        Text(
            text = item.biography,
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ActionItem(
                label = "Website",
                icon = R.drawable.website,
                lightBlue = lightBlue,
                enabled = item.site.isNotBlank()
            ) {
                item.site.let(onOpenWebsite)
            }
            ActionItem(
                label = "Message",
                icon = R.drawable.message,
                lightBlue = lightBlue,
                enabled = item.site.isNotBlank()
            ) {
                onSendSms(item.mobile, "The SMS Text")
            }
            ActionItem(
                label = "Call",
                icon = R.drawable.call,
                lightBlue = lightBlue,
                enabled = item.mobile.isNotBlank(),
            ) {
                onDial(item.mobile)
            }
            ActionItem(
                label = "Direction",
                icon = R.drawable.website,
                lightBlue = lightBlue,
                enabled = item.site.isNotBlank()
            ) {
                item.location.let(onDirection)
            }
            ActionItem(
                label = "Share",
                icon = R.drawable.share,
                lightBlue = lightBlue,
                enabled = true
            ) {
                val subject = "Check out this doctor: ${item.name}"
                val text = "Speciality: ${item.special}\nLocation: ${item.location}\nMobile: ${item.mobile}"
                onShare(subject, text)
            }
        }
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = darkBlue,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Book Appointment",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Spacer(Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DetailBodyPreview() {
        DetailBody(
            item = DoctorModel(
                name = "Dr. John Doe",
                special = "Cardiologist",
                location = "New York, USA",
                patients = "1000+",
                experience = 10,
                rating = 4.8
            ),
            onOpenWebsite = {},
            onSendSms = { _, _ -> },
            onDial = {},
            onDirection = {},
            onShare = { _, _ -> }
        )
}
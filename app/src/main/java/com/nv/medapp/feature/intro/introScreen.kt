package com.nv.medapp.feature.intro

//import android.graphics.Color
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
import androidx.compose.ui.graphics.BlendMode.Companion.Color
//import androidx.compose.ui.graphics.Color
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


@Composable
fun IntroScreen(onStartClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = colorResource(id = R.color.kawaii_sky_blue))
    ){
        Image(
            painter = painterResource(id = R.drawable.white_halo),
            contentDescription = null,
            modifier = Modifier.align(Alignment.TopCenter).fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Image(
            painter = painterResource(id = R.drawable.intro_women),
            contentDescription = null,
            modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(Modifier.height(height = 24.dp))
        Column(modifier = Modifier
            .align(Alignment.TopStart)
            .statusBarsPadding()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
        ){
            Text(
                text = stringResource(id = R.string.sub_intro),
                fontFamily = FontFamily(Font(R.font.dm_sans)),
                fontSize = 24.sp,
                color = colorResource(id = R.color.white),
                modifier = Modifier.padding(bottom = 8.dp),
                fontWeight = FontWeight.Bold,
                lineHeight = 32.sp,
            )
            Button(
                onClick = onStartClick,
                modifier = Modifier.size(width = 170.dp, height = 60.dp),
                shape = RoundedCornerShape(size = 100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.catalina_blue),
                    contentColor = colorResource(id = R.color.white)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp
                ),
                contentPadding = PaddingValues(start = 8.dp, end = 16.dp)
            ){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.get_started),
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 20.sp
                        )
                    Spacer(modifier = Modifier.width(width = 8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.white_arrow),
                        contentDescription = null,
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun IntroScreenPreview() {
    IntroScreen (onStartClick = {})
}
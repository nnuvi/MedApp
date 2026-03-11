package com.nv.medapp.feature.home

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
import com.nv.medapp.feature.intro.IntroScreen


@Composable
fun HomeBottomBar(selected: Int, onSelect: (Int) -> Unit) {
    NavigationBar(
        containerColor = colorResource(id = R.color.catalina_blue),
        modifier = Modifier.height(60.dp),
        tonalElevation = 10.dp,
        windowInsets = WindowInsets(left = 0)
    ) {
        val titles = listOf("Explorer", "Wishlist", "Settings", "Account")
        val icons = listOf(
            R.drawable.btn_1,
            R.drawable.btn_2,
            R.drawable.btn_3,
            R.drawable.btn_4
        )
        titles.forEachIndexed { index, title ->
            NavigationBarItem(
                selected = selected == index,
                onClick = { onSelect(index) },
                icon = {
                    Icon(
                        painter = painterResource(id = icons[index]),
                        contentDescription = title,
//                        tint = if (selected == index) {
//                            colorResource(id = R.color.white)
//                        } else {
//                            colorResource(id = R.color.white)
//                        },
                        modifier = Modifier.size(24.dp),
                    )
                },
                label = {
                    Text(
                        text = title,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.dm_sans)),
                        fontWeight = FontWeight.Bold,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.kawaii_sky_blue),
                    unselectedIconColor = colorResource(id = R.color.white),
                    selectedTextColor = colorResource(id = R.color.kawaii_sky_blue),
                    unselectedTextColor = colorResource(id = R.color.white),
                    indicatorColor = Color.Transparent // optional
                ),
                alwaysShowLabel = true
            )
        }
    }
}

@Preview
@Composable
fun HomeBottomBarPreview() {
    HomeBottomBar (selected = 0, onSelect = {})
}
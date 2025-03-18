package com.example.firebase.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firebase.viewmodel.LoginViewModel

@Composable
fun TabsView(navController: NavController, loginVM : LoginViewModel) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Iniciar sesión", "Registrase")
    Column {
        Spacer(Modifier.height(30.dp))
        TabRow(
            selectedTabIndex = selectedTab,
            contentColor = Color.Black,
            indicator = { tabPosition ->
                TabRowDefaults.apply {
                    HorizontalDivider(
                        Modifier
                            .tabIndicatorOffset(tabPosition[selectedTab])
                            .height(4.dp),
                        color = Color.Blue
                    )
                }
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }
        when (selectedTab) {
            0 -> LoginScreen(navController, loginVM)
            1 -> RegistroScreen(navController, loginVM)
        }
    }
}




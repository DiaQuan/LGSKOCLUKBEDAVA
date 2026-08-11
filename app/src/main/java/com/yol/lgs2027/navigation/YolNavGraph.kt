package com.yol.lgs2027.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yol.lgs2027.ui.components.PlaceholderScreen

@Composable
fun YolNavGraph(navController: NavHostController = rememberNavController()) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showBottomBar = bottomNavDestinations.any { it.route == currentRoute }

    Scaffold(
        bottomBar = { if (showBottomBar) YolBottomBar(navController, currentRoute) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destination.Splash.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Destination.Splash.route) { PlaceholderScreen("Açılış") }
            composable(Destination.Auth.route) { PlaceholderScreen("Giriş / Kayıt") }
            composable(Destination.Onboarding.route) { PlaceholderScreen("Onboarding") }
            composable(Destination.Dashboard.route) { PlaceholderScreen("Dashboard") }
            composable(Destination.Pomodoro.route) { PlaceholderScreen("Pomodoro") }
            composable(Destination.Schedule.route) { PlaceholderScreen("Program") }
            composable(Destination.Notes.route) { PlaceholderScreen("Notlar") }
            composable(Destination.Tracking.route) { PlaceholderScreen("İstatistik / Deneme") }
            composable(Destination.Goals.route) { PlaceholderScreen("Hedefler") }
            composable(Destination.AiCoach.route) { PlaceholderScreen("AI Koç") }
            composable(Destination.Badges.route) { PlaceholderScreen("Rozetler") }
            composable(Destination.Settings.route) { PlaceholderScreen("Ayarlar") }
            composable(Destination.Profile.route) { PlaceholderScreen("Profil") }
            composable(Destination.Admin.route) { PlaceholderScreen("Admin") }
        }
    }
}

@Composable
private fun YolBottomBar(navController: NavHostController, currentRoute: String?) {
    val items = listOf(
        Triple(Destination.Dashboard, Icons.Filled.Home, "Ana Sayfa"),
        Triple(Destination.Pomodoro, Icons.Filled.Timer, "Pomodoro"),
        Triple(Destination.Tracking, Icons.Filled.BarChart, "İstatistik"),
        Triple(Destination.AiCoach, Icons.Filled.Psychology, "AI Koç"),
        Triple(Destination.Profile, Icons.Filled.Person, "Profil")
    )

    NavigationBar {
        items.forEach { (destination, icon, label) ->
            NavigationBarItem(
                selected = currentRoute == destination.route,
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) }
            )
        }
    }
}

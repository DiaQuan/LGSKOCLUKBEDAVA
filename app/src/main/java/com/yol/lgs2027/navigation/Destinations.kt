package com.yol.lgs2027.navigation

sealed class Destination(val route: String) {
    data object Splash : Destination("splash")
    data object Auth : Destination("auth")
    data object Onboarding : Destination("onboarding")
    data object Dashboard : Destination("dashboard")
    data object Pomodoro : Destination("pomodoro")
    data object Schedule : Destination("schedule")
    data object Notes : Destination("notes")
    data object Tracking : Destination("tracking")
    data object Goals : Destination("goals")
    data object AiCoach : Destination("ai_coach")
    data object Badges : Destination("badges")
    data object Settings : Destination("settings")
    data object Profile : Destination("profile")
    data object Admin : Destination("admin")
}

// Alt navigasyon çubuğunda gösterilecek 5 ana sekme (kalanlar profil/menüden erişilecek)
val bottomNavDestinations = listOf(
    Destination.Dashboard,
    Destination.Pomodoro,
    Destination.Tracking,
    Destination.AiCoach,
    Destination.Profile
)

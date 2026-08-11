package com.yol.lgs2027.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val YolDarkColorScheme = darkColorScheme(
    primary = YolPrimary,
    onPrimary = YolText,
    secondary = YolSecondary,
    onSecondary = YolText,
    tertiary = YolGlow,
    background = YolBg,
    onBackground = YolText,
    surface = YolBgSecondary,
    onSurface = YolText,
    error = YolDanger,
    onError = YolText
)

@Composable
fun YolTheme(content: @Composable () -> Unit) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        val window = (view.context as Activity).window
        window.statusBarColor = YolBg.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
    }

    MaterialTheme(
        colorScheme = YolDarkColorScheme,
        shapes = YolShapes,
        typography = YolTypography,
        content = content
    )
}

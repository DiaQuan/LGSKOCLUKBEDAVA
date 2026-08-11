package com.yol.lgs2027.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yol.lgs2027.ui.theme.YolGlow

/**
 * Sitedeki .glass-card stilinin karşılığı: yarı saydam gradient yüzey + ince kenarlık.
 * Gerçek bulanıklık (blur) sadece Android 12+ (API 31+) Modifier.blur ile mümkün;
 * daha eski cihazları da desteklemek için burada yarı saydam katman kullanıyoruz.
 */
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    cornerRadius: Int = 16,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.White.copy(alpha = 0.08f), Color.White.copy(alpha = 0.04f))
                ),
                shape = RoundedCornerShape(cornerRadius.dp)
            )
            .border(
                width = 1.dp,
                color = YolGlow.copy(alpha = 0.15f),
                shape = RoundedCornerShape(cornerRadius.dp)
            )
            .padding(20.dp)
    ) {
        content()
    }
}

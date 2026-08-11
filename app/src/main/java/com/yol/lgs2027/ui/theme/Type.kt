package com.yol.lgs2027.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Sitede Space Grotesk (başlık) + Inter (gövde) + JetBrains Mono (sayısal veri) var.
// Şimdilik sistem fontuyla başlıyoruz ki her şey ilk seferde çalışsın.
// Gerçek fontları eklemek için: Google Fonts'tan .ttf dosyalarını indir,
// res/font/ klasörüne koy, sonra burada:
//   val YolDisplayFont = FontFamily(Font(R.font.space_grotesk_bold, FontWeight.Bold))
// şeklinde değiştir.
val YolDisplayFont = FontFamily.SansSerif
val YolBodyFont = FontFamily.SansSerif
val YolMonoFont = FontFamily.Monospace

val YolTypography = Typography(
    headlineLarge = TextStyle(fontFamily = YolDisplayFont, fontWeight = FontWeight.Bold, fontSize = 32.sp),
    headlineMedium = TextStyle(fontFamily = YolDisplayFont, fontWeight = FontWeight.Bold, fontSize = 24.sp),
    titleLarge = TextStyle(fontFamily = YolDisplayFont, fontWeight = FontWeight.SemiBold, fontSize = 20.sp),
    bodyLarge = TextStyle(fontFamily = YolBodyFont, fontWeight = FontWeight.Normal, fontSize = 16.sp),
    bodyMedium = TextStyle(fontFamily = YolBodyFont, fontWeight = FontWeight.Normal, fontSize = 14.sp),
    labelLarge = TextStyle(fontFamily = YolBodyFont, fontWeight = FontWeight.Medium, fontSize = 14.sp)
)

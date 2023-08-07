package com.hugidonic.core.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hugidonic.core.R

val playfair_bold = Font(R.font.playfair_bold)
val playfair_black = Font(R.font.playfair_black)
val playfair_med = Font(R.font.playfair_med)
val playfair_reg = Font(R.font.playfair_reg)

val opensans_reg = Font(R.font.opensans_reg)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily(playfair_black),
        fontWeight = FontWeight.Black,
        letterSpacing = 1.sp,
        fontSize = 32.sp,
    ),

    h2 = TextStyle(
        fontFamily = FontFamily(playfair_bold),
        letterSpacing = 1.sp,
        fontSize = 20.sp,
    ),

    body1 = TextStyle(
        fontFamily = FontFamily(opensans_reg),
        letterSpacing = 0.5.sp,
        fontSize = 16.sp,
    ),

    body2 = TextStyle(
        fontFamily = FontFamily(opensans_reg),
        letterSpacing = 0.5.sp,
        fontSize = 14.sp,
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
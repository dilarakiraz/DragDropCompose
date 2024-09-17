package com.example.dragdropcompose

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntOffset
/**
 * Created by Dilara Kiraz on 17.09.2024.
 */
fun Offset.toIntOffset(): IntOffset {
    return IntOffset(x.toInt(), y.toInt())
}
package com.example.dragdropcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntOffset

/**
 * Created by Dilara Kiraz on 17.09.2024.
 */
@Composable
fun DragDropScreen() {
    var items by remember { mutableStateOf(listOf("Item 1", "Item 2", "Item 3", "Item 4")) }
    var draggedItemIndex by remember { mutableStateOf<Int?>(null) }
    var draggedOffset by remember { mutableStateOf(Offset.Zero) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            items.forEachIndexed { index, item ->
                val isDragging = index == draggedItemIndex
                DragDropItem(
                    text = item,
                    isDragging = isDragging,
                    onDragStart = {
                        draggedItemIndex = index
                    },
                    onDragEnd = {
                        draggedItemIndex = null
                        draggedOffset = Offset.Zero
                    },
                    onDrag = { offset ->
                        draggedOffset += offset
                    },
                    modifier = Modifier
                        .offset { if (isDragging) draggedOffset.toIntOffset() else IntOffset(0, 0) }
                )
            }
        }
    }
}
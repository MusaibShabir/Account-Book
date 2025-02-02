package com.musaib.accountbook.presentation.screens.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CashRow(
    startCash: String,
    endCash: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 18.dp), // Added horizontal padding
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Red text (Left-aligned)
        Text(
            text = startCash,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(red = 222, green = 19, blue = 87, alpha = 255),
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp), // Add some space between red text and divider
            textAlign = TextAlign.Start
        )

        // Divider (Centered)
        VerticalDivider(
            modifier = Modifier
                .height(24.dp), // Fixed width to avoid stretching
            color = Color.Black,
            thickness = 1.dp
        )

        // Green text (Right-aligned)
        Text(
            text = endCash,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(red = 25, green = 180, blue = 25, alpha = 255),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp), // Add some space between divider and green text
            textAlign = TextAlign.End
        )
    }
}

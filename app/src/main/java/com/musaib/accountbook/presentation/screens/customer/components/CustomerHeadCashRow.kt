package com.musaib.accountbook.presentation.screens.customer.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.musaib.accountbook.ui.theme.MainGreen


@Composable
fun CustomerHeadCashRow(
    preFixText: String,
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
            text = preFixText,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp), // Add some space between red text and divider
            textAlign = TextAlign.Start
        )


        // Green text (Right-aligned)
        Text(
            text = endCash,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MainGreen,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp), // Add some space between divider and green text
            textAlign = TextAlign.End
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomerHeadCashRow() {

    CustomerHeadCashRow(
        preFixText = "You Will Get",
        endCash = "$ 2000"
    )
}

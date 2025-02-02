package com.musaib.accountbook.presentation.screens.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.musaib.accountbook.ui.theme.MainGreen

@Composable
fun CustomerColumn(
    modifier: Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        item {
            OutlinedCard(
                modifier = modifier
                    .fillMaxWidth()
                    .height(62.dp),
                border = BorderStroke(width = .3.dp, Color.Gray),
                shape = RectangleShape,
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color(red = 119, green = 168, blue = 198, alpha = 74)
                )
            ) {

                Row (
                    modifier = modifier
                        .fillMaxSize()
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
// Name of the Customer
                    Text(
                        text = "Musaib Shabir",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        modifier = Modifier
                            .weight(1f),
                        textAlign = TextAlign.Start
                    )

                    // Name of the Customer
                    Text(
                        text = "$ 300",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = MainGreen,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp), // Add some space between divider and green text
                        textAlign = TextAlign.End
                    )
                }

            }
        }



    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun PreviewHomeScreen() {
    CustomerColumn(modifier = Modifier)
}
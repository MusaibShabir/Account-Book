package com.musaib.accountbook.presentation.screens.customer.components


import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
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
import com.musaib.accountbook.ui.theme.MainRed
import java.util.Date

@Composable
fun ProfileEntryRow(
    modifier: Modifier,
    date: Date,
    time: Date,
    entryAmount: Int,
    entryType: Int,
    entryDescription: String
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
                    .fillMaxWidth(),
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                colors = CardDefaults.outlinedCardColors(



                ),
                border = BorderStroke(
                    width = .5.dp,
                    color = when (entryType) {
                        1 -> MainGreen // Green color for type 1
                        0 -> MainRed // Red color for type 0
                        else -> Color.Gray // Default color if entryType is neither 1 nor 0
                    }
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
            ) {

                Row (
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column (
                        modifier = modifier
                            .height(IntrinsicSize.Min),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = AbsoluteAlignment.Left
                    ){
                        Row(
                            modifier = modifier
                                .fillMaxWidth(.4f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ){

                            // Date
                            Text(
                                text = "29 JAN 25",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start

                            )

                            Spacer(modifier.width(8.dp))

                            // Time
                            Text(
                                text = "07:53 PM",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,

                            )
                        }

                        Spacer(modifier.height(18.dp))

                        // Description
                        Text(
                            text = entryDescription,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            textAlign = TextAlign.Start
                        )

                    }


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
    ProfileEntryRow(
        modifier = Modifier,
        date = Date(),
        time = Date(),
        entryAmount = 300,
        entryType = 1,
        entryDescription = "Cash"
    )
}
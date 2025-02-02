package com.musaib.accountbook.presentation.screens.customer.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.musaib.accountbook.data.viewModel.TransactionViewModel
import com.musaib.accountbook.ui.theme.MainGreen
import com.musaib.accountbook.ui.theme.MainRed
import androidx.compose.foundation.lazy.items

@Composable
fun ProfileEntryRow(
    modifier: Modifier = Modifier,
    viewModel: TransactionViewModel // Pass ViewModel here
) {
    val transactions by viewModel.allTransactions.collectAsState() // Collect the state here
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Ensure you are passing the List directly
        items(transactions) { transaction -> // items expects a List, so pass the list of transactions
            OutlinedCard(
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                colors = CardDefaults.outlinedCardColors(),
                border = BorderStroke(
                    width = .5.dp,
                    color = if (transaction.amount >= 0) MainGreen else MainRed
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
            ) {
                Row(
                    modifier = modifier.fillMaxWidth().padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = modifier.height(IntrinsicSize.Min),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            modifier = modifier.fillMaxWidth(0.4f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = transaction.date,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = transaction.time,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                            )
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        // Description
                        Text(
                            text = transaction.description,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            textAlign = TextAlign.Start
                        )
                    }

                    // Amount
                    Text(
                        text = "₹ ${transaction.amount}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (transaction.amount >= 0) MainGreen else MainRed,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp),
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}


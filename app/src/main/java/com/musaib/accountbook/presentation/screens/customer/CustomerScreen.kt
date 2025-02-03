package com.musaib.accountbook.presentation.screens.customer

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.musaib.accountbook.data.viewModel.CustomerViewModel
import com.musaib.accountbook.data.viewModel.TransactionViewModel
import com.musaib.accountbook.navigation.NavRoutes
import com.musaib.accountbook.presentation.screens.customer.components.CustomerHeadCashRow
import com.musaib.accountbook.presentation.screens.customer.components.ProfileEntryRow
import com.musaib.accountbook.presentation.screens.customer.components.ProfileTopAppBar
import com.musaib.accountbook.ui.theme.MainGreen
import com.musaib.accountbook.ui.theme.MainRed

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CustomerTransactionScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    transactionViewModel: TransactionViewModel,
    customerViewModel: CustomerViewModel,
) {
    val customerId by customerViewModel.selectedCustomerId.collectAsState()

    LaunchedEffect(key1 = customerId) {
        if (customerId != null) {
            transactionViewModel.getTransactionsForCustomer(customerId!!)
        }
    }

    Scaffold(
        topBar = {
            ProfileTopAppBar(
                title = "Musaib",
                navController = navController
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = Color.Transparent) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Max),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Gave
                    Button(
                        onClick = {
                            navController.navigate(NavRoutes.ADD_AMOUNT)
                            transactionViewModel.setTransactionType(0)
                                  },
                        modifier = modifier
                            .weight(3f)
                            .padding(8.dp),
                        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = MainRed)
                    ) {
                        Text(text = "YOU GAVE ₹", fontWeight = FontWeight.Medium)
                    }
                    Spacer(modifier = Modifier.width(12.dp))

                    // Got
                    Button(
                        onClick = {
                            navController.navigate(NavRoutes.ADD_AMOUNT)
                            transactionViewModel.setTransactionType(1)
                        },
                        modifier = modifier
                            .weight(3f)
                            .padding(8.dp),
                        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = MainGreen)
                    ) {
                        Text(text = "YOU GOT ₹", fontWeight = FontWeight.Medium)
                    }
                }
            }
        },
        content = {
                paddingValues ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Max),
                    colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                ) {
                    CustomerHeadCashRow(preFixText = "You will get", endCash = "$ 7337")
                }

                HorizontalDivider(
                    thickness = .5.dp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 18.dp),
                )

                // Pass ViewModel to ProfileEntryRow
                ProfileEntryRow(modifier = modifier, viewModel = transactionViewModel)
            }
        }
    )
}


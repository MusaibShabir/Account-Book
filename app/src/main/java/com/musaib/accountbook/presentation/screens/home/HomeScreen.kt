package com.musaib.accountbook.presentation.screens.home

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.musaib.accountbook.data.viewModel.CustomerViewModel
import com.musaib.accountbook.navigation.NavRoutes
import com.musaib.accountbook.presentation.screens.home.components.CashRow
import com.musaib.accountbook.presentation.screens.home.components.CustomerColumn

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CustomerViewModel
) {

    val customers by viewModel.allCustomers.collectAsState(initial = emptyList())
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            ,

        floatingActionButton = {

            FloatingActionButton(
                onClick = { navController.navigate(NavRoutes.ADD_CUSTOMER)},
            ) {
                Row(
                    modifier = Modifier
                        .width(IntrinsicSize.Max)
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Add",
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Add Customer",
                        fontSize = 18.sp
                    )
                }

            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
        ) {
            ElevatedCard (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
            ) {
                CashRow(startCash = "$ 4759", endCash = "$ 7337")

            }

            HorizontalDivider(
                thickness = .5.dp,
                color = Color.Black,
                modifier = modifier.padding(vertical = 18.dp),
            )

            CustomerColumn(
                customers = customers,
                onCustomerClick = { customerId ->
                    viewModel.setSelectedCustomerId(customerId)
                    navController.navigate(NavRoutes.CUSTOMER_TRANSACTION)
                },
                cardType = 0
            )
        }
    }

}

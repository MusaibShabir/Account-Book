package com.musaib.accountbook.presentation.screens.customer

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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.musaib.accountbook.data.viewModel.TransactionViewModel
import com.musaib.accountbook.presentation.screens.customer.components.CustomerHeadCashRow
import com.musaib.accountbook.presentation.screens.customer.components.ProfileEntryRow
import com.musaib.accountbook.ui.theme.MainGreen
import com.musaib.accountbook.ui.theme.MainRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerTransactionScreen(
    modifier: Modifier = Modifier,
    viewModel: TransactionViewModel // Add ViewModel parameter
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Musaib Shabir") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.size(18.dp)
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = Color.Transparent) {
                Row(
                    modifier = modifier.fillMaxWidth().height(IntrinsicSize.Max),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {},
                        modifier = modifier.weight(3f).padding(8.dp),
                        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = MainRed)
                    ) {
                        Text(text = "YOU GAVE ₹", fontWeight = FontWeight.Medium)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Button(
                        onClick = {},
                        modifier = modifier.weight(3f).padding(8.dp),
                        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = MainGreen)
                    ) {
                        Text(text = "YOU GOT ₹", fontWeight = FontWeight.Medium)
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(18.dp)
        ) {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max),
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
            ProfileEntryRow(modifier = modifier, viewModel = viewModel)
        }
    }
}


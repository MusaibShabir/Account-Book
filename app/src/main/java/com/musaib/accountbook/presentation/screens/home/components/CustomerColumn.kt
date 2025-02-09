package com.musaib.accountbook.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.musaib.accountbook.currentRoute
import com.musaib.accountbook.data.tables.Customer
import com.musaib.accountbook.ui.theme.MainGreen
import com.musaib.accountbook.ui.theme.MainRed

@Composable
fun CustomerColumn(
    customers: List<Customer>,
    onCustomerClick: (Int) -> Unit,
    cardType: Int = 0
) {
    val typeColor = when (cardType) {
        0 -> MainRed
        1 -> MainGreen
        else -> {Color.Black}
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(
            items = customers,
            key = { it.id }
        ) { customer ->
            CustomerCard(
                customer = customer,
                onCustomerClick = { onCustomerClick(customer.id) },
                amountColor = typeColor
            )
        }
    }
}

@Composable
fun CustomerCard(
    customer: Customer,
    onCustomerClick: () -> Unit,
    amountColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCustomerClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = customer.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )

            Text(
                text = "₹ 7323",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = amountColor
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomerColumnPreview() {
    val customers = listOf(
        Customer(id = 1, name = "John Doe", createdAt = "2023-10-27", updatedAt = "2023-10-28"),
        Customer(id = 2, name = "Jane Smith", createdAt = "2023-10-26", updatedAt = "2023-10-27"),
        Customer(id = 3, name = "Peter Jones", createdAt = "2023-10-25", updatedAt = "2023-10-26")
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "Customers")
        CustomerColumn(customers = customers, onCustomerClick = {})
    }
}
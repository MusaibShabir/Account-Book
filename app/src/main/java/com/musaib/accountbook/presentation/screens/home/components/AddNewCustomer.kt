package com.musaib.accountbook.presentation.screens.home.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController

@Composable
fun AddNewCustomer(
    modifier: Modifier,
    navController: NavController

) {
    Dialog(
        onDismissRequest = {
            navController.popBackStack()
        }
    ) {

        var newCustomerName by rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth(),
            prefix = {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Add Customer",
                    modifier = modifier.size(18.dp)
                )
                Spacer(modifier.width(16.dp))
            },
            placeholder = {
                Text(
                    text = "Enter amount",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,

                    )
            },
            value = newCustomerName,
            onValueChange = { newText ->
                newCustomerName = newText
            },
            textStyle = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Gray,
                cursorColor = Color.Black,
            )


        )
    }
}
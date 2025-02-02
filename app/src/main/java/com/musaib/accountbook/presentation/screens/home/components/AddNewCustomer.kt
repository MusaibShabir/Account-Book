package com.musaib.accountbook.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.musaib.accountbook.data.viewModel.CustomerViewModel

@Composable
fun AddNewCustomer(
    modifier: Modifier,
    navController: NavController,
    viewModel: CustomerViewModel
) {
    Dialog(
        onDismissRequest = {
            navController.popBackStack()
        }
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(18.dp)
                )
                .padding(18.dp),
        ){
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
                label = {
                    Text(
                        text = "Enter New Customer Name",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,

                        )
                },
                value = newCustomerName,
                onValueChange = { newText ->
                    newCustomerName = newText
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        navController.popBackStack()
                    }
                ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Black,
                )
            )

            // Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        if (newCustomerName.isNotEmpty()) {
                            viewModel.addCustomer(newCustomerName)
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(text = "Add")
                }
            }
        }
    }
}
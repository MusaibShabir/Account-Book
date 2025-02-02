package com.musaib.accountbook.presentation.screens.customer.components


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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.musaib.accountbook.ui.theme.MainGreen
import com.musaib.accountbook.ui.theme.MainRed
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterAmountScreen(
    modifier: Modifier = Modifier,
    profileName: String,
    entryType: Int,
) {
    // Entry Color
    var entryColor = when (entryType) {
        1 -> MainGreen // Green color for type 1
        0 -> MainRed // Red color for type 0
        else -> Color.Gray // Default color if entryType is neither 1 nor 0
    }

    // Date Logic
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDateMillis by remember { mutableStateOf<Long?>(null) }
    var selectedDateString by remember { mutableStateOf("") }

    val noFutureDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            val date = Instant.ofEpochMilli(utcTimeMillis)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
            return date <= LocalDate.now()
        }
    }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = selectedDateMillis,
        yearRange = 1922..2100,
        selectableDates = noFutureDates

    )

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    Icon(
                        imageVector = Icons. AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.size(18.dp)
                    )
                }
            )
        },
        bottomBar = {

            BottomAppBar(
                containerColor = Color.Transparent
            ){
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Max),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){

                    Button(
                        onClick = {},
                        modifier = modifier
                            .weight(1f)
                            .padding(8.dp),
                        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = entryColor,
                        )
                    ) {
                        Text(
                            text = "SAVE",
                            fontWeight = FontWeight.Medium,
                            )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(18.dp),
        ) {

            var amount by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth(),
                prefix = {
                    Text(
                        text = "₹",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = entryColor,

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
                value = amount,
                onValueChange = { newText ->
                    amount = newText
                },
                textStyle = TextStyle(
                    color = entryColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = entryColor,
                    focusedIndicatorColor = entryColor,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = entryColor,
                )


            )
            HorizontalDivider(
                thickness = .5.dp,
                color = Color.Black,
                modifier = modifier.padding(vertical = 18.dp),
            )

            var entryDescription by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Enter Description",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,

                        )
                },
                value = entryDescription,
                onValueChange = { newText ->
                    entryDescription = newText
                },
                textStyle = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                ),

                trailingIcon = {
                    IconButton(
                        onClick = {showDatePicker = true }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.DateRange,
                            contentDescription = "Date Picker"
                        )
                    }
                },

                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Black,
                )

            )

            if (showDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { showDatePicker = false },
                    confirmButton = {
                        Button(
                            onClick = {
                                showDatePicker = false
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MainGreen)
                        ) {
                            Text("Confirm")
                        }
                    },
                    colors = DatePickerDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.background,
                        todayDateBorderColor = MainGreen,
                        todayContentColor = MaterialTheme.colorScheme.onBackground
                    ),
                    content = {
                        DatePicker(
                            state = datePickerState,
                            title = { Text(
                                text = "Enter date",
                                modifier = modifier.padding(22.dp)
                            ) },
                            colors = DatePickerDefaults.colors(
                                containerColor = MaterialTheme.colorScheme.background,
                                selectedDayContentColor = MaterialTheme.colorScheme.background,
                                selectedDayContainerColor = MainGreen,
                                selectedYearContainerColor = MainGreen,
                                dayInSelectionRangeContentColor = MainGreen,
                                todayDateBorderColor = MainGreen,
                                todayContentColor = MaterialTheme.colorScheme.onBackground
                            )
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCustomerProfileScreen() {
    EnterAmountScreen(
        modifier = Modifier,
        profileName = "Musaib Shabir",
        entryType = 1
    )
}
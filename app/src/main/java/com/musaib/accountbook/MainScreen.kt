package com.musaib.accountbook



import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.musaib.accountbook.data.viewModel.CustomerViewModel
import com.musaib.accountbook.data.viewModel.TransactionViewModel
import com.musaib.accountbook.navigation.NavRoutes
import com.musaib.accountbook.presentation.screens.customer.CustomerTransactionScreen
import com.musaib.accountbook.presentation.screens.customer.components.EnterAmountScreen
import com.musaib.accountbook.presentation.screens.home.HomeScreen
import com.musaib.accountbook.presentation.screens.home.components.AddNewCustomer


// Helper function to get the current route
@Composable
fun currentRoute(navController: NavHostController): String {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route ?: ""
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun MainScreen(modifier: Modifier) {
    val navController = rememberNavController()
    val currentRoute = currentRoute(navController)

    // ViewModels Instances
    val customerViewModel: CustomerViewModel = hiltViewModel()
    val transactionViewModel: TransactionViewModel = hiltViewModel()

    Scaffold{innerPadding ->

        NavHost(
            navController = navController,
            startDestination = NavRoutes.HOME,
            modifier = modifier.padding(innerPadding)
        ) {

            // Screens WITH Navigation Bar
            composable(NavRoutes.HOME) {
                HomeScreen(
                    modifier = modifier,
                    navController = navController,
                    viewModel = customerViewModel
                )
            }

            composable(NavRoutes.CUSTOMER_TRANSACTION) {
                CustomerTransactionScreen(
                    modifier = modifier,
                    customerViewModel = customerViewModel,
                    transactionViewModel = transactionViewModel,
                    navController = navController
                )
            }

            composable(NavRoutes.ADD_CUSTOMER) {
                AddNewCustomer(
                    modifier = modifier,
                    navController = navController,
                    viewModel = customerViewModel
                )
            }

            composable(NavRoutes.ADD_AMOUNT) {
                EnterAmountScreen(
                    modifier = modifier,
                    navController = navController,
                    transactionViewModel = transactionViewModel,
                    customerViewModel = customerViewModel
                )
            }


        }
    }
}







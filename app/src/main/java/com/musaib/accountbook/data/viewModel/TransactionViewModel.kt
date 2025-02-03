package com.musaib.accountbook.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musaib.accountbook.data.TransactionRepository
import com.musaib.accountbook.data.tables.Transaction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val repository: TransactionRepository,
) : ViewModel() {

    // Transactions
    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions.asStateFlow()

    val allTransactions: StateFlow<List<Transaction>> = repository.getAllTransactions()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun insertTransaction(
        amount: Double,
        description: String,
        date: String,
        time: String,
        customerId: Int,
        type: Int // "GAVE" or "GOT"
    ) {
        viewModelScope.launch {
            val transaction = Transaction(
                amount = amount,
                description = description,
                date = date,
                time = time,
                customerId = customerId,
                type = type
            )
            repository.insertTransaction(transaction)
        }
    }

    // Transaction Type
    private val _selectedTransactionType = MutableStateFlow<Int?>(null)
    val selectedTransactionType: StateFlow<Int?> = _selectedTransactionType.asStateFlow()


    fun setTransactionType(transactionType: Int?) {
        _selectedTransactionType.value = transactionType
    }

    // Customer Id
    private val _customerId = MutableStateFlow<Int?>(null)
    val customerId: StateFlow<Int?> = _customerId.asStateFlow()

    fun getTransactionsForCustomer(customerId: Int) {
        _customerId.value = customerId
    }


    // Here
    @OptIn(ExperimentalCoroutinesApi::class)
    val transactionsByCustomer: StateFlow<List<Transaction>> = _customerId.flatMapLatest { customerId ->
        if (customerId != null) {
            repository.getAllTransactionsByCustomerId(customerId)
        } else {
            MutableStateFlow(emptyList())
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

}

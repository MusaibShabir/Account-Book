package com.musaib.accountbook.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musaib.accountbook.data.CustomerDao
import com.musaib.accountbook.data.CustomerRepository
import com.musaib.accountbook.data.tables.Customer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(
    private val customerDao: CustomerDao,
    private val repository: CustomerRepository
) : ViewModel() {

    val allCustomers: Flow<List<Customer>> = customerDao.getAllCustomers()

    fun addCustomer(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
            val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
            val customer = Customer(name = name, createdAt = currentDate, updatedAt = currentTime)
            customerDao.insertCustomer(customer)
        }
    }


    private val _customers = MutableStateFlow<List<Customer>>(emptyList())
    val customers: StateFlow<List<Customer>> = _customers.asStateFlow()

    private val _selectedCustomerId = MutableStateFlow<Int?>(null)
    val selectedCustomerId: StateFlow<Int?> = _selectedCustomerId.asStateFlow() // This

    init {
        getAllCustomers()
    }

    fun getAllCustomers() {
        viewModelScope.launch {
            repository.getAllCustomers().collect {
                _customers.value = it
            }
        }
    }

    fun setSelectedCustomerId(customerId: Int?) {
        _selectedCustomerId.value = customerId
    }
}
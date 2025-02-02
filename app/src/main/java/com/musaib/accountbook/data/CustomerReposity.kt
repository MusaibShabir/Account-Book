package com.musaib.accountbook.data

import com.musaib.accountbook.data.tables.Customer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CustomerRepository @Inject constructor(
    private val customerDao: CustomerDao
) {

    fun getAllCustomers(): Flow<List<Customer>> {
        return customerDao.getAllCustomers()
    }

    suspend fun insertCustomer(customer: Customer) {
        customerDao.insertCustomer(customer)
    }

    suspend fun getCustomerById(customerId: Int): Customer? {
        return customerDao.getCustomerById(customerId)
    }
}
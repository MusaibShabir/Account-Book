package com.musaib.accountbook.data

import com.musaib.accountbook.data.tables.Transaction
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val transactionDao: TransactionDao,
) {
    fun getAllTransactions(): Flow<List<Transaction>> {
        return transactionDao.getAllTransactions()
    }

    suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }

    fun getAllTransactionsByCustomerId(customerId: Int): Flow<List<Transaction>> {
        return transactionDao.getTransactionsByCustomerId(customerId)
    }
}
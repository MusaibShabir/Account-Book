package com.musaib.accountbook.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.musaib.accountbook.data.tables.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions WHERE customerId = :customerId")
    suspend fun getTransactionsByCustomerId(customerId: Int): List<Transaction>

    @Query("SELECT SUM(amount) FROM transactions WHERE customerId = :customerId")
    suspend fun getTotalAmountForCustomer(customerId: Int): Double

    @Query("SELECT * FROM transactions")
    fun getAllTransactions(): Flow<List<Transaction>>
}

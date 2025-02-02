package com.musaib.accountbook.di

import android.content.Context
import com.musaib.accountbook.data.TransactionDao
import com.musaib.accountbook.data.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTransactionRepository(
        transactionDao: TransactionDao,
        @ApplicationContext context: Context
    ): TransactionRepository {
        return TransactionRepository(transactionDao, context)
    }
}

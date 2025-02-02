package com.musaib.accountbook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.musaib.accountbook.data.tables.Customer
import com.musaib.accountbook.data.tables.Transaction

const val DATABASE_VERSION = 2
@Database(entities = [Transaction::class, Customer::class], version = DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun customerDao(): CustomerDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "transaction_database"
                )
                    .addMigrations(MIGRATION_1_2)  // ✅ Add migration
                    .build()
                INSTANCE = instance
                instance
            }
        }

        // ✅ Define Migration from Version 1 to 2
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Add new "customers" table
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS customers (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                            "name TEXT NOT NULL, " +
                            "phone TEXT NOT NULL)"
                )
            }
        }
    }
}

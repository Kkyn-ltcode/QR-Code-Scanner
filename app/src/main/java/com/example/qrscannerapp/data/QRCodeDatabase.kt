// com/example/qrscannerapp/data/QRCodeDatabase.kt
package com.example.qrscannerapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QRCodeEntity::class], version = 1)
abstract class QRCodeDatabase : RoomDatabase() {
    abstract fun qrCodeDao(): QRCodeDao

    companion object {
        @Volatile
        private var INSTANCE: QRCodeDatabase? = null

        fun getDatabase(context: Context): QRCodeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QRCodeDatabase::class.java,
                    "qr_code_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

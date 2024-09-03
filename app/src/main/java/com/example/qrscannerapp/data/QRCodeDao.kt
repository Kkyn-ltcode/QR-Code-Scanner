// com/example/qrscannerapp/data/QRCodeDao.kt
package com.example.qrscannerapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QRCodeDao {
    @Insert
    suspend fun insert(qrCode: QRCodeEntity)

    @Query("SELECT * FROM qr_codes ORDER BY timestamp DESC")
    suspend fun getAll(): List<QRCodeEntity>
}

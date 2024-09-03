// com/example/qrscannerapp/data/QRCodeEntity.kt
package com.example.qrscannerapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "qr_codes")
data class QRCodeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String,
    val timestamp: Long
)

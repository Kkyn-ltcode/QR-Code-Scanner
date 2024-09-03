// com/example/qrscannerapp/ui/history/HistoryAdapter.kt
package com.example.qrscannerapp.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qrscannerapp.data.QRCodeEntity
import com.example.qrscannerapp.databinding.ItemQrCodeBinding

class HistoryAdapter(private val qrCodes: List<QRCodeEntity>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemQrCodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(qrCodes[position])
    }

    override fun getItemCount(): Int = qrCodes.size

    inner class HistoryViewHolder(private val binding: ItemQrCodeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(qrCode: QRCodeEntity) {
            binding.qrCodeContent.text = qrCode.content
            binding.qrCodeTimestamp.text = android.text.format.DateFormat.format("yyyy-MM-dd HH:mm:ss", qrCode.timestamp)
        }
    }
}

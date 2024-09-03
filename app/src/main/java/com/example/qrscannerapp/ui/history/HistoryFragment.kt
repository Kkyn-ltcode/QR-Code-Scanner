// com/example/qrscannerapp/ui/history/HistoryFragment.kt
package com.example.qrscannerapp.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qrscannerapp.data.QRCodeDatabase
import com.example.qrscannerapp.databinding.FragmentHistoryBinding
import kotlinx.coroutines.launch

class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.historyRecyclerView.layoutManager = LinearLayoutManager(context)

        val qrCodeDao = QRCodeDatabase.getDatabase(requireContext()).qrCodeDao()

        lifecycleScope.launch {
            val qrCodes = qrCodeDao.getAll()
            binding.historyRecyclerView.adapter = HistoryAdapter(qrCodes)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

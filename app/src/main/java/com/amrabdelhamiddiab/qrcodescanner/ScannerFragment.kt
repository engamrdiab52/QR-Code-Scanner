package com.amrabdelhamiddiab.qrcodescanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.amrabdelhamiddiab.qrcodescanner.databinding.FragmentScannerBinding
import com.amrabdelhamiddiab.qrcodescanner.databinding.FragmentWaitingBinding

class ScannerFragment : Fragment() {

    private lateinit var binding: FragmentScannerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_scanner, container, false)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scanner, container, false)
    }
}
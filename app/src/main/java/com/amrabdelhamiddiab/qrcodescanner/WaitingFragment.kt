package com.amrabdelhamiddiab.qrcodescanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.amrabdelhamiddiab.qrcodescanner.databinding.FragmentFirstBinding
import com.amrabdelhamiddiab.qrcodescanner.databinding.FragmentWaitingBinding

class WaitingFragment : Fragment() {
    private lateinit var binding: FragmentWaitingBinding
   // private val args : WaitingFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_waiting, container, false)
    //    val qrcode = args.qrcode.qrcode
      //  binding.textView2.text = qrcode
        // Inflate the layout for this fragment
        return binding.root
    }

}
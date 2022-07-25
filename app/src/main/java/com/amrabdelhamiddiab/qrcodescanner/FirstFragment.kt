package com.amrabdelhamiddiab.qrcodescanner

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Size
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.amrabdelhamiddiab.qrcodescanner.databinding.FragmentFirstBinding
import com.google.common.util.concurrent.ListenableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var button: Button
    private lateinit var text: TextView

    companion object {
        const val REQUEST_CODE: Int = 1001
        const val TAG = "MainActivity"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        // Inflate the layout for this fragment
        button = binding.button
        text = binding.textView
        button.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_scannerFragment)
        }

        return binding.root
    }


}
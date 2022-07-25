package com.amrabdelhamiddiab.qrcodescanner

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
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
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.databinding.DataBindingUtil
import com.amrabdelhamiddiab.qrcodescanner.databinding.FragmentFirstBinding
import com.google.common.util.concurrent.ListenableFuture
import java.util.concurrent.ExecutorService

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var button: Button
    private lateinit var text: TextView
    private lateinit var permissionLauncher: ActivityResultLauncher<String>

    companion object {
        const val REQUEST_CODE: Int = 1001
        const val TAG = "MainActivity"
    }
    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>
    private lateinit var cameraExecutor: ExecutorService
    private lateinit var analyzer: MyImageAnalyzer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                // Do if the permission is granted
                Toast.makeText(requireContext(), "permission Already granted", Toast.LENGTH_LONG)
                    .show()
            } else {
                // Do otherwise
                //   Toast.makeText(requireContext(), "permission Denied", Toast.LENGTH_LONG).show()
                showPermissionDeniedDialog()
            }
        }
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
            text.text = "AAAAAA"
            askForCameraPermission()
        }
        return binding.root
    }

    private fun askForCameraPermission() {
        permissionLauncher.launch(Manifest.permission.CAMERA)
    }


    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Permission Denied")
            .setMessage("Permission is denied, Please allow permissions from App Settings.")
            .setPositiveButton(
                "App Settings"
            ) { _, _ ->
                // send to app settings if permission is denied permanently
                val intent = Intent()
                intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                val uri = Uri.fromParts("package", requireActivity().packageName, null)
                intent.data = uri
                startActivity(intent)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
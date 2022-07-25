package com.amrabdelhamiddiab.qrcodescanner

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class MyImageAnalyzer(
    private val context: Context,
    private val textView: TextView,
    private val linearLayout: LinearLayout,
    private val preview: androidx.camera.view.PreviewView
) :
    ImageAnalysis.Analyzer {
    override fun analyze(imageProxy: ImageProxy) {
        scanBarcode(imageProxy)
    }

    @SuppressLint("UnsafeExperimentalUsageError", "UnsafeOptInUsageError")
    private fun scanBarcode(imageProxy: ImageProxy) {
        imageProxy.image?.let { image ->
            val inputImage = InputImage.fromMediaImage(image, imageProxy.imageInfo.rotationDegrees)
            val scanner = BarcodeScanning.getClient()
            scanner.process(inputImage)
                .addOnCompleteListener {
                    imageProxy.close()
                    if (it.isSuccessful) {
                        readBarcodeData(it.result as List<Barcode>)
                    } else {
                        it.exception?.printStackTrace()
                    }
                }
        }
    }

    private fun readBarcodeData(barcodes: List<Barcode>) {
        for (barcode in barcodes) {
            when (barcode.valueType) {
                Barcode.TYPE_TEXT -> {
                    Toast.makeText(context, barcode.displayValue, Toast.LENGTH_SHORT).show()
                    //   barcode.displayValue?.let { Log.d(TAG, it) }
                    //   navController.navigate(nav)
                    preview.visibility = View.GONE
                    linearLayout.visibility = View.VISIBLE
                    textView.text = barcode.displayValue
                }
            }
        }
    }
}
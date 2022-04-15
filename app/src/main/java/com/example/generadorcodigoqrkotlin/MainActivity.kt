package com.example.generadorcodigoqrkotlin

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ivCodigoQR: ImageView = findViewById(R.id.ivCodigoQR)
        var etDatos: EditText = findViewById(R.id.etDatos)
        var btnGenerar: Button = findViewById(R.id.btnGenerar)

        btnGenerar.setOnClickListener(View.OnClickListener {

            try {

                var barcodeEncoder: BarcodeEncoder = BarcodeEncoder()
                var bitmap: Bitmap = barcodeEncoder.encodeBitmap(
                    etDatos.text.toString(),
                    BarcodeFormat.QR_CODE,
                    750,
                    750
                )

                ivCodigoQR.setImageBitmap(bitmap)


            } catch (e: Exception) {
                e.printStackTrace()
            }

        })
    }
}
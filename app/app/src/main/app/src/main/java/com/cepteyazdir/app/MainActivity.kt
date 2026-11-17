package com.cepteyazdir.app

import android.app.Activity
import android.os.Bundle
import android.hardware.usb.UsbManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.view.ViewGroup
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val usbManager = getSystemService(USB_SERVICE) as UsbManager

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(30, 50, 30, 30)

        val title = TextView(this)
        title.text = "CEPTE YAZDIR"
        title.textSize = 28f
        layout.addView(title)

        val status = TextView(this)
        status.text = "Yazıcı bekleniyor..."
        layout.addView(status)

        val button = Button(this)
        button.text = "USB YAZICIYI BUL"
        layout.addView(button)

        button.setOnClickListener {
            val devices = usbManager.deviceList.values

            status.text = if (devices.isEmpty()) {
                "USB yazıcı bulunamadı."
            } else {
                devices.joinToString("\n") {
                    "USB cihazı: ${it.deviceName}\nÜretici ID: ${it.vendorId}\nÜrün ID: ${it.productId}"
                }
            }
        }

        setContentView(layout)
    }
}

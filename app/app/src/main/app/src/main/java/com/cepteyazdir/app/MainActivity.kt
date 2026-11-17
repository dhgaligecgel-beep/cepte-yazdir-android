package com.cepteyazdir.app

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(32, 50, 32, 32)

        val title = TextView(this)
        title.text = "CEPTE YAZDIR"
        title.textSize = 28f
        layout.addView(title)

        val status = TextView(this)
        status.text = "Canon LBP6310dn - USB bağlantısı bekleniyor"
        status.textSize = 16f
        layout.addView(status)

        val connect = Button(this)
        connect.text = "USB YAZICIYI KONTROL ET"
        layout.addView(connect)

        connect.setOnClickListener {
            status.text = "USB bağlantısı kontrol edilecek."
        }

        setContentView(layout)
    }
}
